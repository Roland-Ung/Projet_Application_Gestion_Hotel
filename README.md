# Application pour la gestion d'hôtel

⚠️ Ce projet est pédagogique et ne remplace pas une application professionnel pour la gestion d'hôtel

## Membres
- Roland Ung
- Viswadevi Narayanasamychettiar

## Objectif
- Développer une application Java de gestion hôtelière permettant de centraliser la gestion des clients, des chambres, des réservations, des séjours, des produits mini bar et des consommations.
- L’application comporte une interface avec menus et sous-menus afin de faciliter les opérations courantes d’un hôtel, comme l’ajout, la modification et la suppression d’éléments, ainsi que la consultation des données enregistrées.

## Fonctionnalités

### 1 - Gestion des clients
- Ajouter un client dans la base de donnée
- Modifier les coordonées d'un client ou le supprimer
- Consultation de la liste des clients inscrits

### 2 - Gestion des chambres
- Ajouter une nouvelle chambre disponible
- Modifier les caractéristiques d'une chambre ou le supprimer
- Consultation de la liste des chambres présentes

### 3 - Gestion des produits mini bar
- Ajouter un nouveau produit mini bar en vente
- Modifier les informations d'un produit ou le supprimer
- Consultation de la liste des produits mini bar

### 4 - Gestion des réservations
- **Dépend de 1 et 2**
- Enregistrer une réservation
- Modifier ses détails ou l'annuler
- Historique des réservations faites

### 5 - Gestion des séjours
- **Dépend de 4**
- Créer un séjour
- Valider si le séjour a été payé
- Historique des séjours passés

### 6 - Gestion des consommations
- **Dépend de 3 et 5**
- Enregistrer une consommation
- Modifier ses détails ou l'annuler
- Historique des consommations des produits

## Installation et Utilisation

**Prérequis**
- Java JDK 11 ou supérieur
- Eclipse IDE (recommandé)

**1. Cloner le dépôt**
```bash
git clone https://github.com/Roland-Ung/Projet_Application_Gestion_Hotel.git
```

**2. Importer le projet dans Eclipse**

**3. Lancer la class MainVue**



## Structure du projet
```
Projet_Application_Gestion_Hotel/
│
├── src/
│   ├── controleur/    Gestion des boutons : ajouter, supprimer, modifier
│   ├── model/         Entités métiers : client, chambre, réservations...
│   └── vue/           Affichage de la fenêtre et des menus
├── .classpath         Configuration du classpath pour Eclipse
├── .project           Fichier de configuration du projet Eclipse
├── .gitignore         Fichiers à exclure de Git
└── README.md
```
