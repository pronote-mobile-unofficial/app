# Requests

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
GCryptage.cryptageRSA.encrypter(GApplication.getCommunication().ivAESTemp);
```
where `.ivAESTemp` equals to:
```javascript
new forge.util.ByteBuffer(forge.random.generate(16));
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

