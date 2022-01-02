# President-election-system
Simple president election system

# Information
**Framework: Spring**  
**Programming language: Kotlin**  

# How to use the system ? 
**URL: "/api/elections/candidates"**

## See all candidates

**method: GET**  
**RESPONSE**  
-`200   OK` **successful case**
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


