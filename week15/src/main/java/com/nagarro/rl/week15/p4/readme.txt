Transcoding from UTF-8 to Latin1 is not always possible
because UTF-8 is capable of encoding a much larger range of characters than Latin1.
UTF-8 can represent any character in the Unicode standard, while Latin1 is limited to only 256 characters.
Therefore, some of the characters in the UTF-8 file may not have a corresponding representation in the Latin1 encoding,
and it is impossible to represent those characters in the Latin1 encoded file.