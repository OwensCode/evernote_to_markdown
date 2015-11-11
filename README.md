# evernote_to_markdown
This tool converts Notes from Evernote to Markdown files. **In average it takes only 1 minute from downloading the tool until you have your notes as Markdown files.**

This software is especially useful for anyone who wants to maintain notes outside of Evernote, without beeing dependent on the Evernote app.

## Features
 * Simple and fast: Download it, put your Evernotes next to the dowloaded file, and run it. Within seconds, your have all your Evernotes as Markdown files.
 * The software extracts every note out of the Evernote export format `.enex` as single `.md` file, including each note's content **and** tags. The tags are placed as part of the file name, e.g. `title-of-note[tag1_tag1_tag3].md`
 * The output files have clean file names without any unrecommended characters, such as whitespaces or commas.
 * Runs on all platforms with Java installed.
 
## How to use
  * In Evernote, export Notes as an `.enex` file and name it `notes.enex`
  * Download [the latest release here](https://github.com/MathiasRenner/evernote_to_markdown/releases) and put it in the same folder as your `notes.enex` file
  * Make the .jar file executable and run it (either double-click or via terminal). After some seconds, you will see a folder `notes_as_markdown`, which includes all your exported notes as Markdown files.

## Setup development environment for contributors
  * Install [Eclipse](https://eclipse.org/downloads/)
  * In Eclipse, create a new Java project with an arbitrary title and and workspace folder
  * Download all files of this repository, and copy them into the workspace folder of the new Java project (replace existing files).
  * In Eclipse, refresh the project folder to show all copied files
  * Right-click on `bin/xom` -> `build path` -> `add to build path`

#### How to run the software in the dev environment
  * In Evernote, export Notes as an `.enex` file
  * Copy the exported file into the workspace folder of your java project
  * In Eclipse, navigate to `src/evernote_to_markdown`, double-click on `main.java`, left-click on the green **run** button of Eclipse, and choose **Application**.
 
## Known bugs
  * If a note's title is very long or the note has many tags, the software skips these notes and exports all others.
  * A few of the HTML-Tags, which are added by Evernote when exporting, are not beeing deleted by _evernote_to_markdown_ yet.
