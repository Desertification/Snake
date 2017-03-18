#!/usr/bin/env bash
echo "Enter starting value: "
read BEGIN
echo "Enter end value: "
read END
java -cp Snake.jar mybase.UnicodeViewer "$BEGIN" "$END"
