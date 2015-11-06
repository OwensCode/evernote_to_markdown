# evernote_to_markdown
A tool that converts notes from Evernote to Markdown files. It takes about 1 minute until you have all Notes as Markdown files.

This is especially useful for anyone who wants to 
 * maintain notes outside of Evernote, without the dependency the Evernote app,
 * switch from Evernote to other software, such as [tagspaces](http://www.tagspaces.org/ "tagspaces") – a nice Open Source replacement of Evernote.

## Features
 * Simple and fast: Just download, put your Evernotes next to the dowload, and run it. Within seconds, your have all your Evernotes as Markdown files.
 * The software extracts every note out of the Evernote export format `.enex` as single `.md` file, including each note's content
    and tags. The tags are placed as part of the file name, e.g. `title-of-note[tag1_tag1_tag3].md`
 * The output files have clean file names without any unrecommended characters, such as whitespaces or commas.
 * It is tested to work well with [tagspaces](http://www.tagspaces.org/ "tagspaces") as note organizer.
 * Runs on all platforms with Java installed.
 
## How to use
  * In Evernote, export Notes as an `.enex` file and name it `notes.enex`
  * Download ".jar" and put it in the same folder as your notes.enex file
  * Make the .jar file executable and run it. After some seconds, you will receive a folder `notes_as_markdown`, which includes all your exported notes as Markdown files.

## Setup development environment for contributors
  * Install [Eclipse](https://eclipse.org/downloads/)
  * In Eclipse, create new Java project with an arbitrary name and an arbitrary workspace folder
  * Download all files of this repository, and copy them into the workspace folder of the new Java project
  * In Eclipse, refresh the project folder to show all copied files
  * Right-click on `bin/xom` -> `build path` -> `add to build path`

## How to run
  * In Evernote, export Notes as an `.enex` file
  * Copy the exported file into the workspace folder of your java project
  * In Eclipse, navigate to `src/evernote_to_markdown`, double-click on `main.java`, left-click on the "run" button of Eclipse, and choose "Application".
 
## Technology
  * Java
  * [XOM™](http://www.xom.nu/ "XOM™"), a XML object model, an API for processing XML. Here, we used a [fork of the original project](https://github.com/uniba-dsg/XOM), which is developed at the University of Bamberg.

## Known bugs
  * If the Note's title is very long or the note has many tags, the software skips these notes and exports all others.
