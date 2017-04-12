# List of authorizations

> Authorizations are one of the most important things. If a request was sent without checking
the authorizations, your session will be destroyed.

- Boolean:AvecDicussion (true) - Enable messaging
- Boolean:autoriserImpression (true) - Enable printing
- Boolean:avecPDFCertificatScolarite (true) - Enable generating a certificate of schooling
- Object:compte
    + Boolean:avecInformationsPersonnelles (true) - Enables access to personal data
    + Boolean:avecSaisieInfosPersoAutorisations (true) - Enables editing how the school
    can contact you.
    +