# Login

The login process is separed in two steps, the identification and the authentication.

## Identification

```json
{
  "session": session_number,
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
  "session": session_id,
  "numeroOrdre": request_id,
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

## Authentication

First, the challenge is decrypted in AES where :
- iv = `.ivAESTemp` seen at [At Page Loading](#at-page-loading)
- key = username + password (in plain text)
