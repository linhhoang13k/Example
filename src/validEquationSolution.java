boolean n = true, lp = true, rp = false, o = false, e = false, v = true, ea = false;
int pc = 0;

boolean validEquation(String equation) {
    equation = removeWhiteSpace(equation);
    if(equation.indexOf("=")==-1)
        return false;
    char current;
    for(int i = 0; i < equation.length(); i++){
        current = equation.charAt(i);
        if(n && isNum(current))
            continue;
        else if(e && isEqual(current))
            continue;
        else if(lp && isLeftP(current))
            continue;
        else if(rp && isRightP(current))
            continue;
        else if(o && isOperation(current) && i < equation.length()-1)
            continue;
        else if(v && isVariable(current))
            continue;
        else
            return false;
    }
    
    
    return true;
}

boolean isVariable(char c){
    if((c >= 'a' && c <='z') || (c>='A' && c<='Z')){
        n = false;
        o = true;
        lp = false;
        if(pc > 0)
            rp = true;
        v = false;
        if(!ea && pc == 0)
            e = true;
        else
            e = false;
        
        return true;
    }
    return false;
}

boolean isOperation(char c){
    char[] ops = {'+', '-', '*', '^', '/'};
    for(char op : ops){
        if(c == op){
            n = true;
            o = false;
            lp = true;
            rp = false;
            e = false;
            v = true;
            return true;
        }
        
    }
    return false;
    
}
boolean isRightP(char c){
    if(c == ')'){
        pc--;
        o = true;
        if(!ea && pc == 0)
            e = true;
        n = false;
        v = false;
        lp = false;
        return true;
    }
    return false;
}

boolean isLeftP(char c){
    if(c == '('){
        pc++;
        n = true;
        v = true;
        o = false;
        lp = true;
        rp = false;
        e = false;
        return true;
    }
    return false;
    
    
}
boolean isEqual(char c){
    if(c == '='){
        n = true;
        lp = true;
        rp = false;
        v = true;
        e = false;
        o = false;
        ea = true;
        return true;
    }
    return false;
    
}
boolean isNum(char c){
    if(c >= '0' && c <='9'){
        n = true;
        v = true;
        o = true;
        lp = false;
        if(pc == 0 && !ea)
            e = true;
        if(pc > 0)
            rp = true;
        return true;
    }
    return false;
    
}


String removeWhiteSpace(String e){
    
    for(int i = 0; i < e.length(); i++){
        if(e.charAt(i) == ' '){
            e = e.substring(0,i) + e.substring(i+1);
        }
    }
    return e;
    
}