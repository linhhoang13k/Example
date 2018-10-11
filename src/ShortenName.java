/*
You need to insert a bunch of names in the database, but some of them are too large and should be shortened. Each name is given in one of the two formats:

<surname>, <name> <middlename>;
<surname>, <name>.
It is known that <surname> and <middlename> always consist of a single word, and <name> can consist of several words.

Your task is to write a function that will shorten the given name. If it's given in the 1st format, you should cut the middle name and leave only its initial followed by a full stop. If the name is given in the second format, there's no need to shorten it.

Example

For name = "Placedo, Silver Van", the output should be
ShortenName(name) = "Placedo, Silver V".

For name = "Aguilar, Ventura", the output should be
ShortenName(name) = "Aguilar, Ventura".
*/

String ShortenName(String name) {
String s="";
    String[] words = name.split(" ");
    
    if(words.length==2)
    {
        return name;
    }
    else
    {
        for(int i=0; i<words.length-1; i++)
        {
            s+= words[i]+" ";
        }
    }
    s += words[words.length-1].charAt(0) +".";
    return s;
}
