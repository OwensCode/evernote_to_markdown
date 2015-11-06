# evernote_to_markdown
A tool that converts notes from Evernote to Markdown files.

This is especially useful for anyone who wants to 
 * maintain notes outside of Evernote, without the dependency the Evernote app,
 * switch from Evernote to other software, such as [tagspaces](http://www.tagspaces.org/ "tagspaces") which is a nice Open Source replacement of Evernote.


## Features
 * Extracts every note out of the Evernote export format `.enex` as single `.md` file, including each note's content
    and tags. The tags are placed as part of the file name, e.g. `title-of-note[tag1_tag1_tag3].md`
 * The output files have clean file names without any unrecommended characters, such as whitespaces or commas.
 * It is tested to work well with [tagspaces](http://www.tagspaces.org/ "tagspaces") as note organizer.

## How to run
  * Checkout this repo
  * TBA
 
## Technology
  * Java
  * [XOM™](http://www.xom.nu/ "XOM™"), a XML object model, an API for processing XML. Here, we used a [fork of the original project](https://github.com/uniba-dsg/XOM), which is developed at the University of Bamberg.


## Licence

Copyright (C) 2014-2015 [Christian Preißinger](https://github.com/cequ), [Mathias Renner](http://mathias-renner.de)

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License version 3 as 
published by the Free Software Foundation.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
[GNU General Public License](http://opensource.org/licenses/GPL-3.0 "GNU General Public License")
