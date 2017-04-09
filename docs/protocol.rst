# Pronote.NET protocol

## Getting necessary data

Necessary data is given through `onload` data in the html document.
Example `onload` content: 
```javascript
try {
    Start({
        h: '7867662',
        a: 3,
        MR: 'B99B...93E5',
        ER: '0000...0001'
    })
} catch (e) {
    messageErreur(e)
}
```

Only the object passed to `Start` is necessary

Where:
- `h` is the session id : a 7 digit number
- `a` represents the type of page (Cf `EGenreEspace` object)
- `MR` is the server's RSA public key
- `ER` is the RSA modulus to be used for encryption.

If the object doesn't contain these informations,
then it will contain these:
- `sCrA`, *sans cryptage AES*, tells the client not to use AES encryption
- `sCoA`, *sans compression AES*, tells the client not to use AES compression
- `e`, token ID
- `f`, token key
- `g`, type of access
- `p`, page

> **NB**: This data is only given on login pages (e.g. `eleve.html`).

## Requests

Every request have  url like this :

```{host}/pronote/appelfonction/{space}/{session}/{requestnumber}```

Where :
- host: is the host
- space: is referring to the `EGenreEspace` object
- session: is the `h` argument in the `onload` argument (cf. [Getting Necessary Data](#getting-necessary-data))
- requestnumber: is the result of the function :
```javascript
    var communication = GApplication.getCommunication();
    communication.getChaineChiffreeAES(communication.NumeroOrdreCommunication);
```

But, at every request, if **successful** : `communication.NumeroRequete` and `communication.NumeroRequeteCourante` are incremented by 1.

Every request needs the header: `"Content-Type": 'application/json'` and data should be a json parsable string.

## At page loading

On every page loading, the client gives an id to the server : an *uuid*. It's generated with this method
```javascript
GCryptage.cryptageRSA.encrypter(new forge.util.ByteBuffer(forge.random.generate(16)));
```
And the request looks like (*POST*) :
```json
{
  "session": <session number>,
  "numeroOrdre": "<request order>",
  "nom": "FonctionParametres",
  "donneesSec": {
    "donnees": {
      "Uuid": "<long uuid>"
    }
  }
}
```

And server responds with a long list of parameters as example the server's date : a **javascript** parsable json.

## Login

The login process is separed in two steps, the identification and the authentification.

### Login.Identification

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

If the user doesn't exists, the do