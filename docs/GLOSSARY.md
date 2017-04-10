## PRONOTE.NET

There are two Pronote's client: Client Pronote, and PRONOTE.NET.

We base our researches on PRONOTE.NET, which is the web-based client, even if
we found interesting things about that.


## Libraries used
All librairies used can be found in {space}_ext.js

### forge
Forge is an encryption library used by the PRONOTE.NET client.
Please see [here](https://github.com/digitalbazaar/forge) for more informations.

### pako

## Encryption related
### iv
Init Vector. This is a component used in AES-CBC encryption/decryption.

### AES-CBC

Pronote uses a subset of AES encryption, which is AES-CBC.
AES-CBC not only requires a key, but also requires an init
vector. (see *[iv](#iv)*)
