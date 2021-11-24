package esi.g55019.atl.SameGame.Model;


public class Model {
    private Board board;

    public Model() {

    }

    public void initialiseBoard(int nbLigne, int nbColonne, int nbColor){
        this.board = new Board(nbLigne,nbColonne,nbColor);
    }

    public void play(Position pos){
        if(board.isInside(pos)){
            board.supprimerColorSetUp(pos);
            board.faireTomberBille();
            board.concatener();
        }
        else{
            System.out.println("position incorrecte ! ");
        }
    }

    public void displayBoard(){
        board.afficherPlateau();
    }

    public boolean isFinish(){
        return board.isFinish();
    }

    public boolean isWin(){
        return board.isWin();
    }

    public int getScore(){
        return board.getScore();
    }

    public Board getBoard() {
        Board copieDefensive = new Board(board.getLigne(), board.getColonne(),board.getPlateau(), board.getScore());
        return copieDefensive;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}