# On page loading

On every page loading, the client gives an id to the server : an *uuid*.
It's generated with this method:

```javascript
GCryptage.cryptageRSA.encrypter(GApplication.getCommunication().ivAESTemp);
```

where `.ivAESTemp` equals:

```javascript
new forge.util.ByteBuffer(forge.random.generate(16));
```

And the request looks like (*POST*) :
```json
{
  "session": session_id,
  "numeroOrdre": "<request order>",
  "nom": "FonctionParametres",
  "donneesSec": {
    "donnees": {
      "Uuid": "<long uuid>"
    }
  }
}
```

The server's response contains all the data required to parse other responses' contents.
For example, the response contains an array of the school's timetable's hours.


