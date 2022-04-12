field = {
    (0,0) : {"mine": False, "status": "uncovered"},
    (1,1) : {"mine": True, "status": "flagged"}
}

print(field[(0,0)]["mine"])