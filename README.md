# beat-the-dealer

beat-the-dealer is a command line application (cli) for playing a game of blackjack against a dealer.

This program is developed as part of a technical assignment given for a job interview.

## Prerequisites

java 1.8 or above

## Installation

Clone the project
```
git clone https://github.com/mohamead/beat-the-dealer.git
```

Build the executable jar (fatjar) using the gradlew wrapper
```
./gradlew clean task fatjar
```

Locate the jar 
```
cd build/libs/
ls
beat-the-dealer-0.0.1.jar
```

## Usage

See available options with `--help` option
```
$ java -jar beat-the-dealer-0.0.1.jar --help
 __ ___  __ _____  _____ _  _ ___   __  ___  __  _   ___ ___                   
|  \ __|/  \_   _||_   _| || | __|_| _\| __|/  \| | | __| _ \                  
| -< _|| /\ || ||__|| | | >< | _|__| v | _|| /\ | |_| _|| v /                  
|__/___|_||_||_|    |_| |_||_|___| |__/|___|_||_|___|___|_|_\                  
                                                                               
Usage: beat-the-dealer [-h] [-f=<file>]                                        
Command line application (cli) for playing a game of blackjack against a dealer
                                                                               
Options:                                                                       
  -h, --help          output usage information                                 
  -f, --file=<file>   file with the deck of cards                          
                                                                               
Developed by Mohamed Adrik    
```

Run the program
```
$ java -jar beat-the-dealer-0.0.1.jar 
dealer
sam: C5, H4, DJ
dealer: HA, S5, D2, S2
```

Run the program with `--file` option
```
$ java -jar beat-the-dealer-0.0.1.jar --file ../../src/test/resources/validCards.csv 
sam
sam: CA, H9       
dealer: D5, HQ, S8
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[apache-2.0](https://choosealicense.com/licenses/apache-2.0/)