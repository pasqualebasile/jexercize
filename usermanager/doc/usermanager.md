# User Manager

Semplice applicazione per dimostrare la gestione delle relazioni Many To Many.

## Note generali
Per le colonne PK (cioè `Id`) usare sempre `IDENTITY` come strategia di generazione.


## Steps

### 1 - Entities + Relazioni
Gestione delle entità e delle relazioni in maniera errata, ossia usando solo l'annotazione
`@ManyToMany`.

Così ci crea le seguenti tabelle e non è ciò che vogliamo
roles
roles_users
users
users_roles

### 2 - Specifica di @JoinTable
Va molto meglio specificando la join table. Risultato
1. Tabelle `user_role` (nome specificato in @JoinTable)
2. Campi coi nomi definiti nelle joinColumns
3. PK sulla coppia di campi
4. FK corrette, ma con nomi non comprensibili

### 3 - Caricamento di dati + Specifica FK
1. Aggiunto caricamento dati mediante `data.sql` in resources
2. Definita FK per la tabella di raccordo ManyToMany



## Riferimenti
https://www.baeldung.com/jpa-many-to-many


