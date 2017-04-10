# Identification

```json
{
  "session": <session number>,
  "numeroOrdre": "<request order>",
  "nom": "Identification",
  "donneesSec": {
    "donnees": {
      "Identifiant": "<the username>"
    }
  }
}
```

In case where the user exists, it returns a challenge :

```json
{
  "nom": "Identification",
  "session": <session number>,
  "numeroOrdre": <request number>,
  "donneesSec": {
    "nom": "Identification",
    "donnees": {
      "MotDePasse": 0,
      "Login": 1,
      "Challenge": "<a long string>"
    }
  }
}
```

If the user doesn't exists, the `donnees` object is empty.
