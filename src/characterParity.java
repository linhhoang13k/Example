String characterParity(char symbol) {
    if(symbol >= '0' && symbol <= '9')
        return (int)symbol % 2 == 0 ? "even" : "odd";
    else
        return "not a digit";
}
