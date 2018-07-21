@echo off
color 0a
prompt Rex:$g 
REM runs only if javac command is added to the path variable
REM runs only if javac command is added to the path variable
:label
cls
javac com/rex/text/TextEditor.java
java com.rex.text.TextEditor
pause
goto label
