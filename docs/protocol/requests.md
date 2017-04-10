# Requests

Every request have  url like this :

```
{host}/pronote/appelfonction/{space}/{session}/{requestnumber}
```

Where :
- host: is the host
- space: is referring to the `EGenreEspace` object
- session: is the `h` argument in the `onload` argument (cf. [Getting Necessary Data](necessary.md))
- requestnumber: is the outcome of the function :
```javascript
    var communication = GApplication.getCommunication();
    communication.getChaineChiffreeAES(communication.NumeroOrdreCommunication);
```

On every **successful** request : `communication.NumeroRequete` and `communication.NumeroRequeteCourante` are incremented by 1.

Every request needs the header: `Content-Type: 'application/json'` and data should be a json parsable string.

