# Login

The login process is separed in two steps, the identification and the
authentication.

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

In case the user exists, it returns a challenge :

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

> Even if `donnees` is empty, it will always send an Authentication request,
probably in order to clear the login attempt out of memory.
> Hypothesis: Overflowing the server's memory with that technique.

## Authentication

Then, it decrypt with :
- iv = the init vector used to crypt the UUID : `.ivAESTemp` seen at [Page Loading](onload.md)
- cle = if there are no CAS, it's the password. *Else*, it's username+password
- alea = true *([Salt](#Salt))*

And recrypt it.

> This is used to sign the message from the client to check if client and
server have the same keys

It finally returns a new request with XML data :

```json
{
    "session": session_number,
    "numeroOrdre": "E4DA3S7FBBCE2345D7772B0674A318D5067d6b262bbbf13ca47dc3eb0d2f2d1e",
    "nom": "Authentification",
    "donneesSec": {
        "xml": "<Authentification><Connexion G=\"0\"\/><Challenge T=\"3\">{long challenge}<\/Challenge><\/Authentification>"
    }
}
```

If the provided password is wrong, the server responds :

```json
{
    "session": session_number,
    "numeroOrdre": "AAB323892FBCC25A6F606EB525FFDC56AE34DDB2CC615392C736759827B7B359",
    "nom": "Authentification",
    "donneesSec": {
        "donnees": {},
        "nom": "Authentification",
        "xml": "<AuthentificationReponse><Acces G=\"1\"/></AuthentificationReponse>"
    }
}
```

Otherwise, it gives an huge object of all data.

```json
{
    "session": session_number,
    "numeroOrdre": "4E732CED3463D06DEDCA9A15B6153677F8F5787E335C2B354ABC0932B7BD524A",
    "nom": "Authentification",
    "donneesSec": {
        "nom": "Authentification",
        "xml": "<AuthentificationReponse>[...]</AuthentificationReponse>",
        "donnees": {.:.}
    }
}
```
See [Authentification Data](authentification-data.md) for fully detailed response.