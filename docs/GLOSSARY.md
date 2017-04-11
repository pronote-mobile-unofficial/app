## PRONOTE.NET

There are two Pronote clients: Client Pronote, and PRONOTE.NET.

We base our researches on PRONOTE.NET, which is the web-based client, even if
we found interesting things about that.

## CAS

CAS means *«Central Authentication Service»*. It allow PRONOTE login
from the ENT without credential if the school has an [ENT](#ent).

## ENT

An ENT, *Espace Numérique de Travail*, is a set of tools available to students,
which pronote may be a part of.

## jQuery
> jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.

See [jQuery's website](https://jquery.com).

## forge
Forge is an encryption library used by the PRONOTE.NET client.
Please see [here](https://github.com/digitalbazaar/forge) for more informations.

## pako
> This project was done to understand how fast JS can be and is it necessary to develop native C modules for CPU-intensive tasks. Enjoy the result!

See [Pako's Github](https://github.com/nodeca/pako).

## iv
Init Vector. This is a component used in AES-CBC encryption/decryption.

## AES-CBC

Pronote uses a subset of AES encryption, which is AES-CBC.
AES-CBC not only requires a key, but also requires an init
vector. (see *[iv](#iv)*)

## CAS

CAS means "Central Authentication Service". It makes possible that if the school has an ENT (Espace Numérique de Travail
= something that harmonize multiples apps for a student), PRONOTE authorize connections from the ENT without login.

## Salt

Salt ("*Aléa*" in the Pronote.NET code) works simply :
It adds a random char between each char (including _space_) :

**Example:**
> Base string = "Hello Dear Friend";
>
> Result = "D**H**d**e**a**l**C**l**u**o**R 0**D**s**e**w**a**P**r**D Z**F**A**r**W**i**r**e**R**n**w**d**"

## _T and V

**_T** stands for _type_ and __V__ for _value_.

## Pronote's client autoconfiguration

You can get the client autoconfiguration file, available at :

```{host}/pronote/ParamClient.pcprn```

This file is encoded in UTF-8 and contains only one line:

```Serveur={host_prefix}:{host_prefix}.index-education.net:49300```

If you try to connect to it using the HTTP protocol and that port, you receive an error :

```
This page don't works
{host} sent an incorrect response.

ERR_INVALID_HTTP_RESPONSE
```

So, we receive a response, but with an another protocol.

This definetely needs more research.