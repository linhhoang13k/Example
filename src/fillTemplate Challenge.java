/*
Client side templates have a way to denote placeholders, to be filled in with dynamic content later. A placeholder in a template has the format {{placeholder}}, and it gets replace with the appropriate value one the page is loaded. For example, a welcome page template may greet a user as "Hello {{name}}" where the user's name is determined later.

Your task is to implement a function that will replace the placeholders in the given template. Note, that the template can contain nested placeholders.

Example

For template = "{{foo}}" and placeholders = [["foo","bar"]], the output should be
fillTemplate(template, placeholders) = "bar".


*/

String fillTemplate(String template, String[][] placeholders) {

    String s="";
    String sw=s;
    int w=0,ei =0,si=0;
    while(w<10)
    {
        
     si= template.lastIndexOf('{');
        if(si==-1)
        {
            break;
        }
        for(int i=si; i<template.length(); i++)
        {
            if(template.charAt(i) =='}' && template.charAt(i+1)=='}')
            {
                ei=(i+2);
                s = template.substring((si-1),(ei));
                sw = template.substring(si+1,(i));
                break;
            }
        }
        for(int d=0; d<placeholders.length; d++)
        {
            if(placeholders[d][0].equals(sw))
            {
                template = template.replace(s,placeholders[d][1]);
   
            }
        }
        w++;
        
    }
    
    return template;
}
