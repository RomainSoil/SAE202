
package com.example.sae202;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Timer;

public class Resolution {

    private Monde monde;
    private GridPane grid;
    private VBox vbox;
    private Stage stage;

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }

    public Resolution() {

    }

    public void Resolution1() {

        /* faire le chemin entre le robot1 et la mine1 */


        int coordXrobot1 = monde.robot1.getX();
        int coordYrobot1 = monde.robot1.getY();

        int coordXmine1 = monde.mine1.getX();
        int coordYmine1 = monde.mine1.getY();

        System.out.println(coordXrobot1);
        System.out.println(coordYrobot1);
        System.out.println(coordXmine1);
        System.out.println(coordYmine1);

        while (coordXmine1 != coordXrobot1 || coordYrobot1 != coordYmine1) {

            System.out.println("Rx " + coordXrobot1);
            System.out.println("RY " + coordYrobot1);
            System.out.println("Mx " + coordXmine1);
            System.out.println("MY " + coordYmine1);
            if (coordXmine1 > coordXrobot1) {
                if (monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Mine) {
                    try {
                        monde.robot1.Est(monde);
                        monde.tour += 1;
                        monde.affichage(grid);
                        coordXrobot1 = coordXrobot1 + 1;
                        vbox.getChildren().set(0, monde.affichageScore());
                        stage.show();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (coordYmine1 < coordYrobot1 && coordXrobot1 != 9) {
                        if (monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Mine) {
                            try {
                                monde.robot1.Nord(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordYrobot1 = coordYrobot1 - 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }

                    } else if (coordYmine1 >= coordYrobot1 && coordYrobot1 != 9) {
                        if (monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Mine) {
                            try {
                                monde.robot1.Sud(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordYrobot1 = coordYrobot1 + 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {

                        try {
                            monde.robot1.Ouest(monde);
                            monde.tour += 1;
                            monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                            monde.affichage(grid);
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            coordXrobot1 = coordXrobot1 - 1;
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }

                    }

                }


            } else if (coordYmine1 < coordYrobot1) {


                if (monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Mine) {
                    try {
                        monde.robot1.Nord(monde);
                        monde.tour += 1;
                        monde.affichage(grid);
                        coordYrobot1 = coordYrobot1 - 1;
                        vbox.getChildren().set(0, monde.affichageScore());
                        stage.show();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (coordXmine1 < coordXrobot1 && coordYrobot1 != 0) {
                        if (monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Mine) {
                            try {
                                monde.robot1.Ouest(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordXrobot1 = coordXrobot1 - 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }

                    } else if (coordXmine1 >= coordXrobot1 && coordXrobot1 != 0) {
                        if (monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Mine) {
                            try {
                                monde.robot1.Est(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordXrobot1 = coordXrobot1 + 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        } else {

                            try {
                                monde.robot1.Sud(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                                coordYrobot1 = coordYrobot1 + 1;
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }


            } else if (coordXmine1 < coordXrobot1) {
                if (monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Mine) {
                    try {
                        monde.robot1.Ouest(monde);
                        monde.tour += 1;
                        monde.affichage(grid);
                        coordXrobot1 = coordXrobot1 - 1;
                        vbox.getChildren().set(0, monde.affichageScore());
                        stage.show();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (coordYmine1 < coordYrobot1 && coordXrobot1 != 0) {
                        if (monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Mine) {
                            try {
                                monde.robot1.Nord(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordYrobot1 = coordYrobot1 - 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }

                    } else if (coordYmine1 >= coordYrobot1 && coordXrobot1 != 0) {
                        if (monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Mine) {
                            try {
                                monde.robot1.Sud(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordYrobot1 = coordYrobot1 + 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {

                        try {
                            monde.robot1.Est(monde);
                            monde.tour += 1;
                            monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                            coordXrobot1 = coordXrobot1 + 1;
                            monde.affichage(grid);
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }

                    }
                }


            } else if (coordYmine1 > coordYrobot1) {


                if (monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Mine) {
                    try {
                        monde.robot1.Sud(monde);
                        monde.tour += 1;
                        monde.affichage(grid);
                        coordYrobot1 = coordYrobot1 + 1;
                        vbox.getChildren().set(0, monde.affichageScore());
                        stage.show();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (coordXmine1 < coordXrobot1 && coordYrobot1 != 9) {
                        if (monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Mine) {
                            try {
                                monde.robot1.Ouest(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordXrobot1 = coordXrobot1 - 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (coordXmine1 >= coordXrobot1 && coordYrobot1 != 9) {
                        if (monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Mine) {
                            try {
                                monde.robot1.Est(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordXrobot1 = coordXrobot1 + 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {

                        try {
                            monde.robot1.Nord(monde);
                            monde.tour += 1;
                            monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                            coordYrobot1 = coordYrobot1 - 1;
                            monde.affichage(grid);
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }

                    }

                }


            }
        }


        while (monde.mine1.getNbMinerais() != 0 || monde.robot1.getStockage() != 0) {
            while (monde.robot1.getStockage() != monde.robot1.getCapStock() && monde.mine1.getNbMinerais() != 0) {
                try {
                    monde.robot1.recolter(monde.mine1);
                    monde.tour += 1;
                    vbox.getChildren().set(0, monde.affichageScore());
                    stage.show();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (DepassementStockage_Exception e) {
                    e.printStackTrace();
                } catch (DepassementCapaciteExtraction e) {
                    e.printStackTrace();
                } catch (CapaciteDeMine e) {
                    e.printStackTrace();
                }
            }


            int coordXent1 = monde.entrepot1.getX();
            int coordYent1 = monde.entrepot1.getY();

            System.out.println(coordXrobot1);
            System.out.println(coordYrobot1);
            System.out.println(coordXmine1);
            System.out.println(coordYmine1);

            while (coordXent1 != coordXrobot1 || coordYrobot1 != coordYent1) {
                System.out.println("Rx " + coordXrobot1);
                System.out.println("RY " + coordYrobot1);
                System.out.println("Mx " + coordXent1);
                System.out.println("MY " + coordYent1);
                if (coordXent1 > coordXrobot1) {
                    if (monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Mine) {
                        try {
                            monde.robot1.Est(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordXrobot1 = coordXrobot1 + 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordYent1 <= coordYrobot1 && coordXrobot1 != 9) {
                            if (monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Mine) {
                                try {
                                    monde.robot1.Nord(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot1 = coordYrobot1 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        } else if (coordYent1 > coordYrobot1 && coordYrobot1 != 9) {
                            if (monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Mine) {
                                try {
                                    monde.robot1.Sud(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot1 = coordYrobot1 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot1.Ouest(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                coordXrobot1 = coordXrobot1 - 1;
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }

                    }


                } else if (coordYent1 < coordYrobot1) {


                    if (monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Mine) {
                        try {
                            monde.robot1.Nord(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordYrobot1 = coordYrobot1 - 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordXent1 < coordXrobot1 && coordYrobot1 != 0) {
                            if (monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Mine) {
                                try {
                                    monde.robot1.Ouest(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot1 = coordXrobot1 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        } else if (coordXent1 >= coordXrobot1 && coordXrobot1 != 0) {
                            if (monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Mine) {
                                try {
                                    monde.robot1.Est(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot1 = coordXrobot1 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            } else {

                                try {
                                    monde.robot1.Sud(monde);
                                    monde.tour += 1;
                                    monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                                    coordYrobot1 = coordYrobot1 + 1;
                                    monde.affichage(grid);
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }


                } else if (coordXent1 < coordXrobot1) {
                    if (monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Mine) {
                        try {
                            monde.robot1.Ouest(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordXrobot1 = coordXrobot1 - 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordYent1 <= coordYrobot1 && coordXrobot1 != 0) {
                            if (monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Mine) {
                                try {
                                    monde.robot1.Nord(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot1 = coordYrobot1 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }

                            }

                        } else if (coordYent1 > coordYrobot1 && coordXrobot1 != 0) {
                            if (monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Mine) {
                                try {
                                    monde.robot1.Sud(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot1 = coordYrobot1 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot1.Est(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                                coordXrobot1 = coordXrobot1 + 1;
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }


                } else if (coordXent1 > coordYrobot1) {


                    if (monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Mine) {
                        try {
                            monde.robot1.Sud(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordYrobot1 = coordYrobot1 + 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordXent1 < coordXrobot1 && coordYrobot1 != 9) {
                            if (monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Mine) {
                                try {
                                    monde.robot1.Ouest(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot1 = coordXrobot1 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else if (coordXent1 >= coordXrobot1 && coordYrobot1 != 9) {
                            if (monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Mine) {
                                try {
                                    monde.robot1.Est(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot1 = coordXrobot1 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot1.Nord(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                                coordYrobot1 = coordYrobot1 - 1;
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }

                    }


                }
            }
            try {
                monde.robot1.deposer(monde.entrepot1);
                monde.tour += 1;
                vbox.getChildren().set(0, monde.affichageScore());
                stage.show();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (monde.mine1.getNbMinerais() == 0 && monde.mine2.getNbMinerais() == 0 && monde.robot1.getStockage() == 0 && monde.robot2.getStockage() == 0) {
                    Text win = new Text("VOUS AVEZ GAGNÉ !");
                    win.setTextAlignment(TextAlignment.CENTER);
                    StackPane vBoxWin = new StackPane();
                    vBoxWin.getChildren().add(win);
                    vBoxWin.setAlignment(win, Pos.CENTER);
                    Scene scnWin = new Scene(vBoxWin, 500, 200);
                    Stage stageWin = new Stage();
                    stageWin.setScene(scnWin);
                    stageWin.sizeToScene();
                    stageWin.setTitle("VICTOIRE");
                    stageWin.show();
                }

            } catch (DepassementStockage_Exception e) {

                e.printStackTrace();
            } catch (SecteurContenance_Exception e) {

                e.printStackTrace();
            }

            while (coordXmine1 != coordXrobot1 || coordYrobot1 != coordYmine1) {

                System.out.println("Rx " + coordXrobot1);
                System.out.println("RY " + coordYrobot1);
                System.out.println("Mx " + coordXmine1);
                System.out.println("MY " + coordYmine1);
                if (coordXmine1 > coordXrobot1) {
                    if (monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Mine) {
                        try {
                            monde.robot1.Est(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordXrobot1 = coordXrobot1 + 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordYmine1 <= coordYrobot1 && coordXrobot1 != 9) {
                            if (monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Mine) {
                                try {
                                    monde.robot1.Nord(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot1 = coordYrobot1 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        } else if (coordYmine1 > coordYrobot1 && coordYrobot1 != 9) {
                            if (monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Mine) {
                                try {
                                    monde.robot1.Sud(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot1 = coordYrobot1 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot1.Ouest(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                coordXrobot1 = coordXrobot1 - 1;
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }

                    }


                } else if (coordYmine1 < coordYrobot1) {


                    if (monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Mine) {
                        try {
                            monde.robot1.Nord(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordYrobot1 = coordYrobot1 - 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordXmine1 < coordXrobot1 && coordYrobot1 != 0) {
                            if (monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Mine) {
                                try {
                                    monde.robot1.Ouest(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot1 = coordXrobot1 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        } else if (coordXmine1 >= coordXrobot1 && coordXrobot1 != 0) {
                            if (monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Mine) {
                                try {
                                    monde.robot1.Est(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot1 = coordXrobot1 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            } else {

                                try {
                                    monde.robot1.Sud(monde);
                                    monde.tour += 1;
                                    monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                                    coordYrobot1 = coordYrobot1 + 1;
                                    monde.affichage(grid);
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }


                } else if (coordXmine1 < coordXrobot1) {
                    if (monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Mine) {
                        try {
                            monde.robot1.Ouest(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordXrobot1 = coordXrobot1 - 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordYmine1 <= coordYrobot1 && coordXrobot1 != 0) {
                            if (monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 - 1] instanceof Mine) {
                                try {
                                    monde.robot1.Nord(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot1 = coordYrobot1 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }

                            }

                        } else if (coordYmine1 > coordYrobot1 && coordXrobot1 != 0) {
                            if (monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Mine) {
                                try {
                                    monde.robot1.Sud(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot1 = coordYrobot1 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot1.Est(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                                coordXrobot1 = coordXrobot1 + 1;
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }


                } else if (coordYmine1 > coordYrobot1) {


                    if (monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Terrain || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Entrepot || monde.leMonde[coordXrobot1][coordYrobot1 + 1] instanceof Mine) {
                        try {
                            monde.robot1.Sud(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordYrobot1 = coordYrobot1 + 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordXmine1 < coordXrobot1 && coordYrobot1 != 9) {
                            if (monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 - 1][coordYrobot1] instanceof Mine) {
                                try {
                                    monde.robot1.Ouest(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot1 = coordXrobot1 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else if (coordXmine1 >= coordXrobot1 && coordYrobot1 != 9) {
                            if (monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Terrain || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Entrepot || monde.leMonde[coordXrobot1 + 1][coordYrobot1] instanceof Mine) {
                                try {
                                    monde.robot1.Est(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot1 = coordXrobot1 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot1.Nord(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot1][coordXrobot1] = new PlanDeau(coordXrobot1, coordYrobot1);
                                coordYrobot1 = coordYrobot1 - 1;
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }

                    }


                }
            }
        }


        stage.show();

        int coordXrobot2 = monde.robot2.getX();
        int coordYrobot2 = monde.robot2.getY();

        int coordXmine2 = monde.mine2.getX();
        int coordYmine2 = monde.mine2.getY();

        System.out.println(coordXrobot2);
        System.out.println(coordYrobot2);
        System.out.println(coordXmine2);
        System.out.println(coordYmine2);

        while (coordXmine2 != coordXrobot2 || coordYrobot2 != coordYmine2) {

            System.out.println("Rx " + coordXrobot2);
            System.out.println("RY " + coordYrobot2);
            System.out.println("Mx " + coordXmine2);
            System.out.println("MY " + coordYmine2);
            if (coordXmine2 > coordXrobot2) {
                if (monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Mine) {
                    try {
                        monde.robot2.Est(monde);
                        monde.tour += 1;
                        monde.affichage(grid);
                        coordXrobot2 = coordXrobot2 + 1;
                        vbox.getChildren().set(0, monde.affichageScore());
                        stage.show();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (coordYmine2 < coordYrobot2 && coordXrobot2 != 9) {
                        if (monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Mine) {
                            try {
                                monde.robot2.Nord(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordYrobot2 = coordYrobot2 - 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }

                    } else if (coordYmine2 >= coordYrobot2 && coordYrobot2 != 9) {
                        if (monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Mine) {
                            try {
                                monde.robot2.Sud(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordYrobot2 = coordYrobot2 + 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {

                        try {
                            monde.robot2.Ouest(monde);
                            monde.tour += 1;
                            monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                            monde.affichage(grid);
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            coordXrobot2 = coordXrobot2 - 1;
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }

                    }

                }


            } else if (coordYmine2 < coordYrobot2) {


                if (monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Mine) {
                    try {
                        monde.robot2.Nord(monde);
                        monde.tour += 1;
                        monde.affichage(grid);
                        coordYrobot2 = coordYrobot2 - 1;
                        vbox.getChildren().set(0, monde.affichageScore());
                        stage.show();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (coordXmine2 < coordXrobot2 && coordYrobot2 != 0) {
                        if (monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Mine) {
                            try {
                                monde.robot2.Ouest(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordXrobot2 = coordXrobot2 - 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }

                    } else if (coordXmine2 >= coordXrobot2 && coordXrobot2 != 0) {
                        if (monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Mine) {
                            try {
                                monde.robot2.Est(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordXrobot2 = coordXrobot2 + 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        } else {

                            try {
                                monde.robot1.Sud(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                                coordYrobot2 = coordYrobot2 + 1;
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }


            } else if (coordXmine2 < coordXrobot2) {
                if (monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Mine) {
                    try {
                        monde.robot2.Ouest(monde);
                        monde.tour += 1;
                        monde.affichage(grid);
                        coordXrobot2 = coordXrobot2 - 1;
                        vbox.getChildren().set(0, monde.affichageScore());
                        stage.show();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (coordYmine2 < coordYrobot2 && coordXrobot2 != 0) {
                        if (monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Mine) {
                            try {
                                monde.robot2.Nord(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordYrobot2 = coordYrobot2 - 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }

                    } else if (coordYmine2 >= coordYrobot2 && coordXrobot2 != 0) {
                        if (monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Mine) {
                            try {
                                monde.robot2.Sud(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordYrobot2 = coordYrobot2 + 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {

                        try {
                            monde.robot2.Est(monde);
                            monde.tour += 1;
                            monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                            coordXrobot2 = coordXrobot2 + 1;
                            monde.affichage(grid);
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }

                    }
                }


            } else if (coordYmine2 > coordYrobot2) {


                if (monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Mine) {
                    try {
                        monde.robot2.Sud(monde);
                        monde.tour += 1;
                        monde.affichage(grid);
                        coordYrobot2 = coordYrobot2 + 1;
                        vbox.getChildren().set(0, monde.affichageScore());
                        stage.show();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (coordXmine2 < coordXrobot2 && coordYrobot2 != 9) {
                        if (monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Mine) {
                            try {
                                monde.robot2.Ouest(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordXrobot2 = coordXrobot2 - 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (coordXmine2 >= coordXrobot2 && coordYrobot2 != 9) {
                        if (monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Mine) {
                            try {
                                monde.robot2.Est(monde);
                                monde.tour += 1;
                                monde.affichage(grid);
                                coordXrobot2 = coordXrobot2 + 1;
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {

                        try {
                            monde.robot2.Nord(monde);
                            monde.tour += 1;
                            monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                            coordYrobot2 = coordYrobot2 - 1;
                            monde.affichage(grid);
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }

                    }

                }


            }
        }


        while (monde.mine2.getNbMinerais() != 0 || monde.robot2.getStockage() != 0) {
            while (monde.robot2.getStockage() != monde.robot2.getCapStock() && monde.mine2.getNbMinerais() != 0) {
                try {
                    monde.robot2.recolter(monde.mine2);
                    monde.tour += 1;
                    vbox.getChildren().set(0, monde.affichageScore());
                    stage.show();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (DepassementStockage_Exception e) {
                    e.printStackTrace();
                } catch (DepassementCapaciteExtraction e) {
                    e.printStackTrace();
                } catch (CapaciteDeMine e) {
                    e.printStackTrace();
                }
            }


            int coordXent2 = monde.entrepot2.getX();
            int coordYent2 = monde.entrepot2.getY();

            System.out.println(coordXrobot2);
            System.out.println(coordYrobot2);
            System.out.println(coordXmine2);
            System.out.println(coordYmine2);

            while (coordXent2 != coordXrobot2 || coordYrobot2 != coordYent2) {
                System.out.println("Rx " + coordXrobot2);
                System.out.println("RY " + coordYrobot2);
                System.out.println("Mx " + coordXent2);
                System.out.println("MY " + coordYent2);
                if (coordXent2 > coordXrobot2) {
                    if (monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Mine) {
                        try {
                            monde.robot2.Est(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordXrobot2 = coordXrobot2 + 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordYent2 <= coordYrobot2 && coordXrobot2 != 9) {
                            if (monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Mine) {
                                try {
                                    monde.robot2.Nord(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot2 = coordYrobot2 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        } else if (coordYent2 > coordYrobot2 && coordYrobot2 != 9) {
                            if (monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Mine) {
                                try {
                                    monde.robot2.Sud(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot2 = coordYrobot2 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot2.Ouest(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                coordXrobot2 = coordXrobot2 - 1;
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }

                    }


                } else if (coordYent2 < coordYrobot2) {


                    if (monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Mine) {
                        try {
                            monde.robot2.Nord(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordYrobot2 = coordYrobot2 - 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordXent2 < coordXrobot2 && coordYrobot2 != 0) {
                            if (monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Mine) {
                                try {
                                    monde.robot2.Ouest(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot2 = coordXrobot2 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        } else if (coordXent2 >= coordXrobot2 && coordXrobot2 != 0) {
                            if (monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Mine) {
                                try {
                                    monde.robot2.Est(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot2 = coordXrobot2 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            } else {

                                try {
                                    monde.robot2.Sud(monde);
                                    monde.tour += 1;
                                    monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                                    coordYrobot2 = coordYrobot2 + 1;
                                    monde.affichage(grid);
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }


                } else if (coordXent2 < coordXrobot2) {
                    if (monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Mine) {
                        try {
                            monde.robot2.Ouest(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordXrobot2 = coordXrobot2 - 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordYent2 <= coordYrobot2 && coordXrobot2 != 0) {
                            if (monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Mine) {
                                try {
                                    monde.robot2.Nord(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot2 = coordYrobot2 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }

                            }

                        } else if (coordYent2 > coordYrobot2 && coordXrobot2 != 0) {
                            if (monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Mine) {
                                try {
                                    monde.robot2.Sud(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot2 = coordYrobot2 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot2.Est(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                                coordXrobot2 = coordXrobot2 + 1;
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }


                } else if (coordXent2 > coordYrobot2) {


                    if (monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Mine) {
                        try {
                            monde.robot2.Sud(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordYrobot2 = coordYrobot2 + 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordXent2 < coordXrobot2 && coordYrobot2 != 9) {
                            if (monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Mine) {
                                try {
                                    monde.robot2.Ouest(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot2 = coordXrobot2 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else if (coordXent2 >= coordXrobot2 && coordYrobot2 != 9) {
                            if (monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Mine) {
                                try {
                                    monde.robot2.Est(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot2 = coordXrobot2 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot2.Nord(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                                coordYrobot2 = coordYrobot2 - 1;
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }

                    }


                }
            }
            try {
                monde.robot2.deposer(monde.entrepot2);
                monde.tour += 1;
                vbox.getChildren().set(0, monde.affichageScore());
                stage.show();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (monde.mine1.getNbMinerais() == 0 && monde.mine2.getNbMinerais() == 0 && monde.robot1.getStockage() == 0 && monde.robot2.getStockage() == 0) {
                    Text win = new Text("VOUS AVEZ GAGNÉ !");
                    win.setTextAlignment(TextAlignment.CENTER);
                    StackPane vBoxWin = new StackPane();
                    vBoxWin.getChildren().add(win);
                    vBoxWin.setAlignment(win, Pos.CENTER);
                    Scene scnWin = new Scene(vBoxWin, 500, 200);
                    Stage stageWin = new Stage();
                    stageWin.setScene(scnWin);
                    stageWin.sizeToScene();
                    stageWin.setTitle("VICTOIRE");
                    stageWin.show();
                }

            } catch (DepassementStockage_Exception e) {

                e.printStackTrace();
            } catch (SecteurContenance_Exception e) {

                e.printStackTrace();
            }

            while (coordXmine2 != coordXrobot2 || coordYrobot2 != coordYmine2) {

                System.out.println("Rx " + coordXrobot2);
                System.out.println("RY " + coordYrobot2);
                System.out.println("Mx " + coordXmine2);
                System.out.println("MY " + coordYmine2);
                if (coordXmine2 > coordXrobot2) {
                    if (monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Mine) {
                        try {
                            monde.robot2.Est(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordXrobot2 = coordXrobot2 + 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordYmine2 < coordYrobot2 && coordXrobot2 != 9) {
                            if (monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Mine) {
                                try {
                                    monde.robot2.Nord(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot2 = coordYrobot2 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        } else if (coordYmine2 >= coordYrobot2 && coordYrobot2 != 9) {
                            if (monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Mine) {
                                try {
                                    monde.robot2.Sud(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot2 = coordYrobot2 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot2.Ouest(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                coordXrobot2 = coordXrobot2 - 1;
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }

                    }


                } else if (coordYmine2 < coordYrobot2) {


                    if (monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Mine) {
                        try {
                            monde.robot2.Nord(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordYrobot2 = coordYrobot2 - 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordXmine2 < coordXrobot2 && coordYrobot2 != 0) {
                            if (monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Mine) {
                                try {
                                    monde.robot2.Ouest(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot2 = coordXrobot2 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        } else if (coordXmine2 >= coordXrobot2 && coordXrobot2 != 0) {
                            if (monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Mine) {
                                try {
                                    monde.robot2.Est(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot2 = coordXrobot2 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            } else {

                                try {
                                    monde.robot1.Sud(monde);
                                    monde.tour += 1;
                                    monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                                    coordYrobot2 = coordYrobot2 + 1;
                                    monde.affichage(grid);
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }


                } else if (coordXmine2 < coordXrobot2) {
                    if (monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Mine) {
                        try {
                            monde.robot2.Ouest(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordXrobot2 = coordXrobot2 - 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordYmine2 < coordYrobot2 && coordXrobot2 != 0) {
                            if (monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 - 1] instanceof Mine) {
                                try {
                                    monde.robot2.Nord(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot2 = coordYrobot2 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }

                            }

                        } else if (coordYmine2 >= coordYrobot2 && coordXrobot2 != 0) {
                            if (monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Mine) {
                                try {
                                    monde.robot2.Sud(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordYrobot2 = coordYrobot2 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot2.Est(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                                coordXrobot2 = coordXrobot2 + 1;
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }


                } else if (coordYmine2 > coordYrobot2) {


                    if (monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Terrain || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Entrepot || monde.leMonde[coordXrobot2][coordYrobot2 + 1] instanceof Mine) {
                        try {
                            monde.robot2.Sud(monde);
                            monde.tour += 1;
                            monde.affichage(grid);
                            coordYrobot2 = coordYrobot2 + 1;
                            vbox.getChildren().set(0, monde.affichageScore());
                            stage.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (DepassementMonde_Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (coordXmine2 < coordXrobot2 && coordYrobot2 != 9) {
                            if (monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 - 1][coordYrobot2] instanceof Mine) {
                                try {
                                    monde.robot2.Ouest(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot2 = coordXrobot2 - 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else if (coordXmine2 >= coordXrobot2 && coordYrobot2 != 9) {
                            if (monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Terrain || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Entrepot || monde.leMonde[coordXrobot2 + 1][coordYrobot2] instanceof Mine) {
                                try {
                                    monde.robot2.Est(monde);
                                    monde.tour += 1;
                                    monde.affichage(grid);
                                    coordXrobot2 = coordXrobot2 + 1;
                                    vbox.getChildren().set(0, monde.affichageScore());
                                    stage.show();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } catch (DepassementMonde_Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            try {
                                monde.robot2.Nord(monde);
                                monde.tour += 1;
                                monde.leMonde[coordXrobot2][coordXrobot2] = new PlanDeau(coordXrobot2, coordYrobot2);
                                coordYrobot2 = coordYrobot2 - 1;
                                monde.affichage(grid);
                                vbox.getChildren().set(0, monde.affichageScore());
                                stage.show();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (DepassementMonde_Exception e) {
                                e.printStackTrace();
                            }

                        }

                    }


                }

            }
        }


    }
    public void setMonde(Monde monde) {
        this.monde = monde;
    }
}
