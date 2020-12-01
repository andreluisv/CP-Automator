# CP-Automator

## Intro
Competitive programming automator to fasten your solutions writing process. This is mainly intended to avoid wasting time copying and pasting pre-written pieces of code. 

## Usage
On terminal, use the following commands:
 - `cpadd`
Runs the Java program to add some code to your main.cpp
 - `cpclear`
 Restores your main.cpp back to the template
 - `cpsave [filename]`
  Saves your main.cpp to a backup file named as [filename].cpp
 - `cpget [filename]`
 Restores your main.cpp to the saved file named as [filename].cpp
 - `cprun`
 Compiles and run your main.cpp with the file "in" as a readable input
  - `cpgo`
 Goes to the competitive programming work directory
## Set up Environment
 1. Set up environment variable for the location of your cloned directory.\
 `export CP_PATH=/home/user/CP-Automator`
2. Set up aliases for the shell scripts\
`alias cpadd='cd $CP_PATH && ./scripts/cpadd.sh'`\
`alias cpclear='cd $CP_PATH && ./scripts/cpclear.sh'`\
`alias cpsave='cd $CP_PATH && ./scripts/cpsave.sh $1'`\
`alias cpget='cd $CP_PATH && ./scripts/cpget.sh $1'`\
`alias cprun='cd $CP_PATH && ./scripts/cprun.sh'`\
`alias cpgo='cd $CP_PATH'`
>You can do this by adding above lines at the end of ~/.bashrc file (Linux)
3. Configure yours algorithms/codes to be visible for the Java program.
Add the text files to the `/algorithms` folder inside the repository.
> You can add sub-folders to it, the program fetches it recursively.