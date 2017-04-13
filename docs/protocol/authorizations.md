# List of authorizations

> Authorizations are one of the most important things. If a request was sent without checking
the authorizations, your session will be destroyed.

- Boolean:AvecDicussion - Enable messaging
- Boolean:autoriserImpression - Enable printing
- Boolean:avecPDFCertificatScolarite - Enable generating a certificate of schooling
- Boolean:AvecSaisieObservationsParents - ?
- Object:compte
    + Boolean:avecInformationsPersonnelles - Enables access to personal data
    + Boolean:avecSaisieIdentifiant - Enables you to change username
    + Boolean:avecSaisieInfosPersoAutorisations - Enables editing how the school (student & school)
    can contact you
    + Boolean:avecSaisieInfosPersoCoordonnees - Enables to change your coordinates (phone number, email)
    + Boolean:avecSaisieMotDePasse - Enables you to change password
    + Boolean:avecSaisieMotDePasseEleve - Enables you to change son/daughter password
- Object:cours
    + Object:domaineConsultationEDT
        * Integer:_T = 8
        * Range: