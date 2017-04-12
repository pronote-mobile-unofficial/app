# Authentication Data

This is composed in multiple parts :
- [Common data](#common-data)
- [Parents](#parents)
- [Students](#students)
- [Teachers](#teachers)

### Syntax

- Type:Name (default content) - Description
    
## Common Data
Supposing that we're in `donneesSec.donnees`

- Boolean:autorisationKiosque (true) - ?
- [Object-Authorizations](authorizations.md):autorisation - Authorizations

## Parents
Supposing that we're in `donneesSec.donnees`

- Object:EnvoiEmailEtablissement - Shows school emails.
    + Boolean:AvecEnvoiEmailEtablissement - Enables that feature
    + String:Secretariat - Secretariat's email
    + String:Webmaster - Webmaster's email
    + [Image](../img/envoi_email_etablissement.jpg)

## Students

## Teachers
Supposing that we're in `donneesSec.donnees`

- Object:UrlInstallClient - Contains link to install the pronote's client.
    + String:V - Link
    + Integer:_T (23) - Type ?
- Object:UrlParamClient - Contains the pronote's client settings (autoconfiguration mode)
    + String:V ("ParamClient.pcprn") - See Pronote's client autoconfiguration
    + Integer:_T (23) - Type ?
- Boolean:autorisationCloud (true) - Authorize importating files from Dropbox, etc...
- Boolean:autorisationIManuel (true) - ?