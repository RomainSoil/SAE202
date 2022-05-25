package application;

public class Robot

{
    private int x;
    private int y;
    private int  numRobot;
    private int capStokage;
    private int capExtraction;
    private int nbMinAct;
    private int Stockage;
    private int Extraction;
    private Secteur sonSecteur;
    private String natureExtrac;

    public Robot(int x, int y, int num, int cS, int cE, int nbM, int stc, String ext)
    {
        this.x=x;
        this.y=y;
        numRobot = num;
        capStokage = cS;
        capExtraction = cE;
        nbMinAct = nbM;
        Stockage = stc;
        natureExtrac = ext;
        Extraction = 0+(int)(Math.random()*((4-0)+1)) ;

    }

    public int getNumRobot()
    {
        return this.numRobot;
    }

    public int getMinAct()
    {
        return this.nbMinAct;
    }

    public int getCapStock()
    {
        return this.capStokage;
    }

    public int getCapExtract()
    {
        return this.capExtraction;
    }

    public String getNatureExtrac() {
		return natureExtrac;
	}

	public void setNatureExtrac(String natureExtrac) {
		this.natureExtrac = natureExtrac;
	}

	public void recolter(Mine mine) throws DepassementStockage_Exception,DepassementCapaciteExtraction,CapaciteDeMine
    {
        if (Stockage < capStokage && Extraction < capExtraction && mine.getNbMinerais() > 0)
        {
            Extraction -=1;
            Stockage -=1;
            mine.ExtractionMinerais();

        }
        if (capStokage < 1 || capStokage < Stockage){
            DepassementStockage_Exception depStock = new DepassementStockage_Exception("Votre capacité de stockage est pleine");
            throw depStock;}
        if (capExtraction <1 ){
            DepassementCapaciteExtraction depExtract = new DepassementCapaciteExtraction("Votre capacité d'extraction est dépassé");
            throw depExtract;}
        if (mine.getNbMinerais() < 1){
            CapaciteDeMine CapMine = new CapaciteDeMine("Il n'y a plus de Minerais dans la mine");
            throw CapMine;}

     
    }
    
    public void deposer(Entrepot entrepot) throws DepassementStockage_Exception, SecteurContenance_Exception
    {
    	if (this.sonSecteur instanceof Entrepot)
    	{
    		if (!( entrepot.getStockInit() == 0) && (!(entrepot.getStockInit() - entrepot.getStockAct() == 0)) && entrepot.getNatureStock().equals(this.getNatureExtrac()) )
    		{
    		entrepot.getStockAct() = entrepot.getStockAct() + this.nbMinAct;
    		entrepot.getStockInit() = entrepot.getStockInit - entrepot.getStockAct();
    		Random2 rand = new Random2(5,9);
    		Random2 rand2 = new Random2(1,3);
    		this.capStokage = rand.getValue();
    		this.capExtraction = rand2.getValue();
    		}
    	}
    	if (entrepot.getStockInit() - this.nbMinAct < 0 || )
    }
    
    public void Nord() throws DepassementMonde_Exception {
        this.y = this.y + 1;
        if (this.y == 0) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous avez ne pouvé pas aller plus loin !");
            throw DE;
        }
    }

    public void Sud () throws DepassementMonde_Exception {
        this.y = this.y - 1;
        if (this.y == 10) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous avez ne pouvé pas aller plus loin !");
            throw DE;
        }
    }

    public void Ouest ()throws DepassementMonde_Exception
    { this.x = this.x - 1;
        if (this.x == 0) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous avez ne pouvé pas aller plus loin !");
            throw DE;
        }
    }

    public void Est ()throws DepassementMonde_Exception
    {
        this.x = this.x + 1;
        if (this.x == 10) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous avez ne pouvé pas aller plus loin !");
            throw DE;
        }
    }

}
