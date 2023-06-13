import { useState } from 'react';
import { Buffer } from 'buffer';

export const authentication = {
  username: 'el',
  password: '123',
};

const BACKEND_ENDPOINT = 'http://localhost:8080';
const BACKEND_MESSAGES = `${BACKEND_ENDPOINT}/messages`;
const BACKEND_LOGIN = `${BACKEND_ENDPOINT}/login`;

export default function App() {
  const initialMessage = 'Outcome will be displayed here...';
  const [message, setMessage] = useState(initialMessage);

  function handleUnauthorized() {
    fetch(BACKEND_MESSAGES + '/unauthorized')
      .then(response => response.text())
      .then(text => setMessage(text))
      .catch(error => console.log('ERROR: ' + error));
  }

  function handleAuthorized() {
    const headers = new Headers();
    const auth = Buffer.from(authentication.username + ':' + authentication.password).toString('base64');
    headers.set('Authorization', 'Basic ' + auth);
    return fetch(BACKEND_MESSAGES + '/authorized', { method: 'GET', headers: headers })
      .then(response => response.text())
      .then(text => setMessage(text))
      .catch(error => console.log('ERROR: ' + error));
  }

  function handleLogin() {
    const headers = new Headers();
    const auth = Buffer.from(authentication.username + ':' + authentication.password).toString('base64');
    headers.set('Authorization', 'Basic ' + auth);
    return fetch(BACKEND_LOGIN, { method: 'GET', headers: headers })
      .then(response => response.text())
      .then(jwt => {
        setMessage('JWT: ' + jwt);
        localStorage.setItem('jwt', jwt);
      })
      .catch(error => console.log('ERROR: ' + error));
  }

  function handleCustomized() {
    const jwt = localStorage.getItem('jwt');
    if (!jwt) {
      setMessage('JWT is not provided');
      return;
    }
    const headers = new Headers();
    headers.set('Authorization', `Bearer ${jwt}`);
    return fetch(BACKEND_MESSAGES + '/authorized/customized', { method: 'GET', headers: headers })
      .then(response => response.text())
      .then(text => setMessage(text))
      .catch(error => console.log('ERROR: ' + error));
  }

  return (
    <>
      <h1>Spring Security JWT</h1>
      <button type='button' onClick={handleUnauthorized}>
        unauthorized message
      </button>
      <button type='button' onClick={handleAuthorized}>
        authorized message
      </button>
      <button type='button' onClick={handleLogin}>
        login
      </button>
      <button type='button' onClick={handleCustomized}>
        customized message
      </button>
      <p>{message}</p>
    </>
  );
}
