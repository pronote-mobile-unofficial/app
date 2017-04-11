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

Then, it decrypt with :
- iv = the init vector used to crypt the UUID : `.ivAESTemp` seen at [Page Loading](onload.md)
- cle = if there are no CAS, it's the password. *Else*, it's username+password
- alea = true *(salt)*

It finally returns 

