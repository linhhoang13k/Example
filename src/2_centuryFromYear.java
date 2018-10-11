/*
*author: @James Cain
*/
int centuryFromYear(int year) 
{
	//Converts a year to a century
    int century=(year/100);

        if(year%100==0)
        {
             return century;   
        }
        else
        {
            century++;
            return century;
        }
}