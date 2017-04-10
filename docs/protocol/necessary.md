# Getting necessary data

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

