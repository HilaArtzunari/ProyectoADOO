
package generadatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Generadatos {

    public static void main(String[] args) {
        
       
        try {
             File archivo=null;
             FileWriter fw=null;
             BufferedWriter bw=null;
             PrintWriter pw=null;
             
            archivo= new File("tabla usuario.txt");
            fw=new FileWriter(archivo);
            bw=new BufferedWriter(fw);
            pw=new PrintWriter(bw);
            
            //Datos de usuario
       for (int a=0;a<10;a++){
            pw.write("INSERT INTO usuario VALUES ('medico"+a+"@gmail.com','medico"+a+"','Nombre Del Medico Numero "+a+"','Aqui va la direccion del medico  Numero "+a+"','555559200"+a+"',3);\r\n");
        }
        for (int a=10;a<100;a++){
            pw.write("INSERT INTO usuario VALUES ('medico"+a+"@gmail.com','medico"+a+"','Nombre Del Medico Numero "+a+"','Aqui va la direccion del medico  Numero "+a+"','55555920"+a+"',3);\r\n");
        }
        for (int a=0;a<10;a++){
            pw.write("INSERT INTO usuario VALUES ('recepcionista"+a+"@gmail.com','recepcionista"+a+"','Nombre Del recepcionista Numero "+a+"','Aqui va la direccion del recepcionista  Numero "+a+"','555559201"+a+"',2);\r\n");
        }
        for (int a=0;a<10;a++){
            pw.write("INSERT INTO usuario VALUES ('cajero"+a+"@gmail.com','cajero"+a+"','Nombre Del Cajero Numero "+a+"','Aqui va la direccion del Cajero  Numero "+a+"','55555922"+a+"',1);\r\n");
        }
        
        for (int a=0;a<10;a++){
            pw.write("INSERT INTO usuario VALUES ('usuario_web"+a+"@gmail.com','usuarioweb"+a+"','Nombre Del Usuario Web Numero "+a+"','Aqui va la direccion del Usuario Web  Numero "+a+"','555552100"+a+"',0);\r\n");
        }
        for (int a=10;a<100;a++){
            pw.write("INSERT INTO usuario VALUES ('usuario_web"+a+"@gmail.com','usuarioweb"+a+"','Nombre Del Usuario Web Numero "+a+"','Aqui va la direccion del Usuario Web  Numero "+a+"','55555210"+a+"',0);\r\n");
        }
        for (int a=100;a<1000;a++){
            pw.write("INSERT INTO usuario VALUES ('usuario_web"+a+"@gmail.com','usuarioweb"+a+"','Nombre Del Usuario Web Numero "+a+"','Aqui va la direccion del Usuario Web  Numero "+a+"','5555521"+a+"',0);\r\n");
        }      
        bw.close();
        archivo= new File("tabla horario.txt");
            fw=new FileWriter(archivo);
            bw=new BufferedWriter(fw);
            pw=new PrintWriter(bw);
        String Dia="lunes";
       int idhorario=0;
       
        for (int dia=0;dia<7;dia++){//Datos de horario
            for (int hora=7;hora<20;hora++){
                for (int minuto=0;minuto<31;minuto=minuto+30){
                   if (dia==0) Dia="Lunes"; 
                    if (dia==1) Dia="Martes"; 
                    if (dia==2) Dia="Miercoles"; 
                    if (dia==3) Dia="Jueves"; 
                    if (dia==4) Dia="Viernes"; 
                    if (dia==5) Dia="Sabado"; 
                    if (dia==6) Dia="Domingo";
                    int horas=hora+4;
                    pw.write("INSERT INTO horario VALUES ("+idhorario+",'"+Dia+"','"+hora+":"+minuto+":0','"+horas+":"+minuto+":0');\r\n");   
                    idhorario++;
                }
            }             
        }
        bw.close();
        
        archivo= new File("tabla medico  horariomedico y horario ocupado.txt");
            fw=new FileWriter(archivo);
            bw=new BufferedWriter(fw);
            pw=new PrintWriter(bw);
            
        //tabla medico y horariomedico
            int idhorarioocupado=0, idhorariomedico=0;
            int idhora=0, consultorio=0, acum=0;
            Random r=new Random();
            for (int a=0;a<100;a++){//Datos de medico
                
                int cedula=(int)1000000+ r.nextInt(8999999);
                pw.write("INSERT INTO medico VALUES ("+cedula+",'medico"+a+"@gmail.com');\r\n");
                acum=0;
                idhora=0;
                while (idhora<177){
                    int saltadia=(int)0+r.nextInt(7);
                    if(saltadia<3){ 
                        acum=idhora+((int)0+r.nextInt(25));
                        consultorio=(int)0+r.nextInt(13);
                        pw.write("INSERT INTO horariomedico VALUES ("+idhorariomedico+","+cedula+","+acum+","+consultorio+" );\r\n"); 
                        for (int dia=1;dia<31;dia++){
                            if (((dia+1)%7)==((int)(acum/26))){
                               int contador=0;
                               for (int time=7;time<20;time++){
                                    for (int hora=0;hora<31;hora=hora+30){
                                         if(contador==(acum-((int)(acum/26))*26)){
                                             for (int i=0;i<4;i++){
                                                int rand, h,m;
                                                rand=(int)0+r.nextInt(7);
                                                if (rand<2){
                                                    h=time+i;
                                                    pw.write("INSERT INTO horarioocupado VALUES ("+idhorarioocupado+","+cedula+",'"+h+":"+hora+":0','16.6."+dia+"');\r\n"); 
                                                    idhorarioocupado++;
                                                }
                                            }
                                        }
                                        contador++;
                                    }
                                }
                            }
                        }
                    }
                    idhora=idhora+25;
                    idhorariomedico++;
                }
            }
            bw.close();
            
            archivo= new File("tabla cita.txt");
            fw=new FileWriter(archivo);
            bw=new BufferedWriter(fw);
            pw=new PrintWriter(bw);
            for (int i=0;i<idhorarioocupado;i++){
                int x,z;
                x=(int)0+r.nextInt(3);
                z=(int)0+r.nextInt(2);
                
                if(x==0){
                    int y=(int)0+r.nextInt(1000);    
                    pw.write("INSERT INTO cita VALUES ("+i+","+i+",'usuario_web"+y+"@gmail.com','Nombre del paciente');\r\n");     
                }
                if(x==1){
                    int y=(int)0+r.nextInt(10);    
                    pw.write("INSERT INTO cita VALUES ("+i+","+i+",'recepcionista"+y+"@gmail.com','Nombre del paciente');\r\n");     
                }
                if(x==2){
                    int y=(int)0+r.nextInt(100);    
                    pw.write("INSERT INTO cita VALUES ("+i+","+i+",'medico"+y+"@gmail.com',"+z+",'Nombre del paciente');\r\n");     
                }
            }
            
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Generadatos.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
