# President-election-system

**Simple president election system**

# Information

**Framework: Spring**  
**Programming language: Kotlin**  
**There are pre-defined information inside data.sql file;**

# How to use the system ?

**URL: "/api/elections/candidates"**

## Fetch all candidates

**Method: GET**  
**Response**

- `200   OK` **successful case**

```json
[
  {
    "number": 1,
    "name": "Aragorn The first",
    "agenda": "Ranger of the North. Heir of Isildur"
  },
  {
    "number": 2,
    "name": "Gandalf from Gandálfr",
    "agenda": "Wizard and the bearer of one of the Three Rings"
  },
  {
    "number": 3,
    "name": "Saruman Wizard",
    "agenda": "Leader of the Istari"
  },
  {
    "number": 4,
    "name": "Gimli  Fearless dwarf",
    "agenda": "Son of Glóin, a member of Thorin's company"
  },
  {
    "number": 5,
    "name": "Legolas Elf",
    "agenda": "Sindar Elf of the Woodland Realm and one of the nine members of the Fellowship"
  }
]
```

# Voting for the particular candidate #

## Register a new vote ##

**Method: POST**

**Important thing to know that there is no option to register a voter. There is a list of free voters which can be use
to test `POST` method.**  
**Definition**`/vote`
**Arguments**

- `"candidateNumber": integer` a number of candidate on the list of all candidates
- `"Id": integer` Identification number of a voter

**Response**

- `201   CREATED` **means the vote is registered**
- `403  FORBIDED` **if users tries to vote again**

```json
{
  "errorMessage": "12345678 have already voted for another candidate!"
}
```

- `404 NOT_FOUND` **means a candidate with such number on the list does not exist**

```json
{
  "errorMessage": "Candidate 0 does not exist!"
}
```

- `404 NOT_FOUND` **means a voter with such ID does not exist in database**

```json
{
  "errorMessage": "Voter 0 does not exist!!"
}
```

# Voting results #
## Overall distribution of votes amongst candidates ##
**Definition**`/votes`

**Response**
- `200 OK ` **means that there is a list returned with information about candidate and his votes count**
```json
[
  {
    "candidate": {
      "number": 1,
      "name": "Aragorn The first",
      "agenda": "Ranger of the North. Heir of Isildur"
    },
    "votesCount": 19
  },
  {
    "candidate": {
      "number": 2,
      "name": "Gandalf from Gandálfr",
      "agenda": "Wizard and the bearer of one of the Three Rings"
    },
    "votesCount": 13
  },
  {
    "candidate": {
      "number": 3,
      "name": "Saruman Wizard",
      "agenda": "Leader of the Istari"
    },
    "votesCount": 13
  },
  {
    "candidate": {
      "number": 4,
      "name": "Gimli  Fearless dwarf",
      "agenda": "Son of Glóin, a member of Thorin's company"
    },
    "votesCount": 22
  },
  {
    "candidate": {
      "number": 5,
      "name": "Legolas Elf",
      "agenda": "Sindar Elf of the Woodland Realm and one of the nine members of the Fellowship"
    },
    "votesCount": 24
  }
]
```