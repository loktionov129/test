# github training
## Remove Cache <BR/>
* git rm -r --cached . <BR/>
* git add . <BR/>
* git commit -m "fixed untracked files" <BR/>
<BR/>

## Create a new repository on the command line <BR/>
* echo "# Gallows" >> README.md <BR/>
* git init <BR/>
* git add README.md <BR/>
* git commit -m "first commit" <BR/>
* git remote add origin git@github.com:loktionov129/Gallows.git <BR/>
* git push -u origin master <BR/>
## Push an existing repository from the command line <BR/>
* git remote add origin git@github.com:loktionov129/Gallows.git <BR/>
* git push -u origin master <BR/>
 <BR/>

## [README.md] Basic writing and formatting syntax
+ https://help.github.com/articles/basic-writing-and-formatting-syntax/

[![NPM version](https://img.shields.io/npm/v/uncss.svg)](https://www.npmjs.com/package/uncss)  
[![Linux Build Status](https://img.shields.io/travis/giakki/uncss/master.svg?label=Linux%20build)](https://travis-ci.org/giakki/uncss)
[![Windows Build status](https://img.shields.io/appveyor/ci/giakki/uncss/master.svg?label=Windows%20build)](https://ci.appveyor.com/project/giakki/uncss/branch/master)
[![Coverage Status](https://img.shields.io/coveralls/giakki/uncss.svg)](https://coveralls.io/r/giakki/uncss?branch=master)  
[![dependencies Status](https://img.shields.io/david/giakki/uncss.svg)](https://david-dm.org/giakki/uncss)
[![devDependencies Status](https://img.shields.io/david/dev/giakki/uncss.svg)](https://david-dm.org/giakki/uncss?type=dev)

<br><br>
```bash
# $1 - filename
# $2 - str to match

for i in $(ls -d */); do
	if [ $(cat "${i%%/}/$1" | grep -i "$2") ]; then
		echo ${i%%/}
	fi
done
```

<br>

```bash
#!/bin/sh
if [ $1 = "2" ]; then
    if test $(wmctrl -l | grep " - WebStorm" 2>&1 | wc -l) -eq 1; then 
        wmctrl -k on && wmctrl -a " - WebStorm"
    elif test $(wmctrl -l | grep " MonoDevelop" 2>&1 | wc -l) -eq 1; then 
        wmctrl -k on && wmctrl -a " MonoDevelop"
    fi
elif [ $1 = "3" ]; then
    if test $(wmctrl -l | grep " - PhpStorm" 2>&1 | wc -l) -eq 1; then 
        wmctrl -k on && wmctrl -a " - PhpStorm"
    elif test $(wmctrl -l | grep "alex@linux" 2>&1 | wc -l) -eq 1; then 
        wmctrl -a "alex@linux"
    fi
else
    wmctrl -k on && wmctrl -a "$1"
fi
```

[![https://github.com/loktionov129/test/blob/master/Penguins.jpg?raw=true](https://github.com/loktionov129/test/blob/master/Penguins.jpg?raw=true)(https://github.com/loktionov129/test/blob/master/Penguins.jpg?raw=true)  
