package application;

public class Robot

{
    private int x;
    private int y;
    private int  numRobot;
    private int capStockage;
    private int capExtraction;
    private int nbMinAct;
    private int Stockage;
    private int Extraction;
    private String natureExtrac;

    public Robot(int x, int y, int num, int cS, int cE, int nbM, int stc, String ext)
    {
        this.x=x;
        this.y=y;
        numRobot = num;
        capStockage = cS;
        capExtraction = cE;
        nbMinAct = nbM;
        Stockage = stc;
        natureExtrac = ext;
        Extraction = 0+(int)(Math.random()*((4-0)+1)) ;

    }


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getNumRobot() {
		return numRobot;
	}


	public void setNumRobot(int numRobot) {
		this.numRobot = numRobot;
	}


	public int getCapStockage() {
		return capStockage;
	}


	public void setCapStokage(int capStokage) {
		this.capStockage = capStockage;
	}


	public int getCapExtraction() {
		return capExtraction;
	}


	public void setCapExtraction(int capExtraction) {
		this.capExtraction = capExtraction;
	}


	public int getNbMinAct() {
		return nbMinAct;
	}


	public void setNbMinAct(int nbMinAct) {
		this.nbMinAct = nbMinAct;
	}


	public int getStockage() {
		return Stockage;
	}


	public void setStockage(int stockage) {
		Stockage = stockage;
	}


	public int getExtraction() {
		return Extraction;
	}


	public void setExtraction(int extraction) {
		Extraction = extraction;
	}


	public String getNatureExtrac() {
		return natureExtrac;
	}


	public void setNatureExtrac(String natureExtrac) {
		this.natureExtrac = natureExtrac;
	}


	public void recolter(Mine mine) throws DepassementStockage_Exception,DepassementCapaciteExtraction,CapaciteDeMine
    {
      if(Stockage == capStockage && Extraction == capExtraction){
		if (Stockage <= capStockage && Extraction <= capExtraction && mine.getNbMinerais() > 0)
        {
            Extraction -=1;
            Stockage -=1;
            mine.ExtractionMinerais();

        }
        if (capStockage < 1 || capStockage < Stockage){
            DepassementStockage_Exception depStock = new DepassementStockage_Exception("Votre capacité de stockage est pleine");
            throw depStock;}
        if (capExtraction <1 || capExtraction < Extraction){
            DepassementCapaciteExtraction depExtract = new DepassementCapaciteExtraction("Votre capacité d'extraction est dépassé");
            throw depExtract;}
        if (mine.getNbMinerais() < 1){
            CapaciteDeMine CapMine = new CapaciteDeMine("Il n'y a plus de Minerais dans la mine");
            throw CapMine;}

    }
    }
    
    public void deposer(Entrepot entrepot) throws DepassementStockage_Exception, SecteurContenance_Exception
    {
    	while (entrepot.getStockInit() > entrepot.getStockAct()) {
    		if (!( entrepot.getStockInit() == 0) && (!(entrepot.getStockInit() - entrepot.getStockAct() == 0)) && entrepot.getNatureStock().equals(this.getNatureExtrac()) )
    		{
    		entrepot.setStockAct(entrepot.getStockAct() + this.nbMinAct);
    		this.setStockage(capStockage);
    		this.setExtraction(capExtraction);
    		}
    	}
    	if (entrepot.getStockInit() - this.nbMinAct < 0 || entrepot.getStockInit() - entrepot.getStockAct() < 0)
    	{
    		DepassementStockage_Exception DS = new DepassementStockage_Exception("Le stockage est devenu négatif !");
    		throw DS;
    	}
    	if ((!(entrepot.getNatureStock().equals(this.getNatureExtrac()))))
    	{
    		SecteurContenance_Exception SC = new SecteurContenance_Exception();
    		throw SC;
    				
    	}
    }
    
    public void Nord(Monde leMonde) throws DepassementMonde_Exception {

        if (this.y == 0 || leMonde.leMonde[x][y-1] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }
        else{
        leMonde.leMonde[x][y].setrobot2();
        this.y = this.y-1;
        leMonde.leMonde[x][y].setrobot1(this);}


    }

    public void Sud (Monde leMonde) throws DepassementMonde_Exception {

        if (this.y == 10 || leMonde.leMonde[x][y+1] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }
        else
        {
        leMonde.leMonde[x][y].setrobot2();
        this.y = this.y + 1;
        leMonde.leMonde[x][y].setrobot1(this);}
    }

    public void Ouest (Monde leMonde)throws DepassementMonde_Exception
    {
        if (this.x == 0 || leMonde.leMonde[x-1][y] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }
        else{
        leMonde.leMonde[x][y].setrobot2();
        this.x = this.x - 1;
        leMonde.leMonde[x][y].setrobot1(this);}

    }

    public void Est (Monde leMonde)throws DepassementMonde_Exception
    {
        if (this.x == 10 || leMonde.leMonde[x+1][y] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }
        else {
        leMonde.leMonde[x][y].setrobot2();
        this.x = this.x + 1;
        leMonde.leMonde[x][y].setrobot1(this);}

    }

}
