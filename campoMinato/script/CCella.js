class CCella{
    constructor(x,y){
        this.colonna = y;
        this.riga = x;
        this.isBomba = false; 
    }

    scopriCella(){
        $('.cella[data-row=' + this.riga + '][data-col=' + this.colonna + ']').css('background-color', "white");
    }

}