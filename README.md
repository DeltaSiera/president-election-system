# President-election-system

**Simple president election system**

# Information

**Framework: Spring**  
**Programming language: Kotlin**  
**There are pre-defined information inside data.sql file;**

# How to use the system ?

**URL: "/api/elections/candidates"**

## Fetch all candidates

**method: GET**  
**RESPONSE**

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

## Voting for the particular candidate ##

## Register a new vote ##

**method: POST**

**Important thing to know that there is no option to register a voter. There is a list of free voters which can be use
to test `POST` method.**  
**Definition**`/votes`
**Arguments**

- `"candidateNumber": integer` a number of candidate on the list of all candidates
- `"Id": integer` Identification number of a voter

**Response**

- `201   CREATED` **means the vote is registered**
- `403  FORBIDED` **if users tries to vote again**

```json
{
  "errorMessage": "A vote has already been cast by the voter 122211"
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
  "errorMessage": "Candidate 0 does not exist!"
}
```