/* The following code demonstrates an example using the Java package
JFreeChart to generate a pie chart using java.  The following is an example
that shows the percentage breakdown of a group of doctors by specialty type.*/
package piechart;


//List of libraries needed to produce a piechart.
/*JPanel is a gui library which generates a panel on which to place
charts and other components in GUIs.*/
import javax.swing.JPanel;

/* This is a collection of different methods to generate a variety of 
different kinds of charts, including a pie chart.  */
import org.jfree.chart.ChartFactory;

//This is a GUI class to help display a JFreeChart object.
import org.jfree.chart.ChartPanel;

//Import the library to create a basic JFreeChart library.  
import org.jfree.chart.JFreeChart;

/*Need to import a class to store the full dataset for the pie chart.
Facilitates placement of some initial default values in the dataset.*/
import org.jfree.data.general.DefaultPieDataset;

/*Would eventually like to return a more general dataset for the pie chart,
so this class is included.*/
import org.jfree.data.general.PieDataset;

/*This is a basic java application chart frame, on which panels and components
of the pie chart can be placed.*/
import org.jfree.ui.ApplicationFrame;

/*This is a library that contains a number of different methods for
setting up GUIs. */
import org.jfree.ui.RefineryUtilities;

/*Pie chart class definition. The piechart plus the panel background
needs to be put on a basic application frame, so ApplicationFrame in
the root class.*/
public class PieChart extends ApplicationFrame 
{
    
   /*Basic constructor for the pie chart, with the chart title as an 
    input arguement. */
    public PieChart( String title) 
            
   {
      //Put the title into the main frame class.
       super( title ); 
      
       /*Set top level visualization and add the chart panel to the
       application. */
      setContentPane(createPanel( ));
   }
   
    
    
    //Panel method to create the display panel on which to place the pie chart.
     public static JPanel createPanel( )
   {
       /*Create a new chart object and add a newly created dataset to the 
       object.  Return this chart object to the panel display.
       The createChart() and createDataset() methods are custom to create
       the desired pie chart.  The createDataset() method is needed as an
       input arguement to the createChart() method.  The createPanel() method
       makes use of both the createChart() and createDataset() methods.*/
       JFreeChart chart = createChart(createDataset( ));  
       return new ChartPanel( chart ); 
   }
   
     
    //Method to set up the dataset for the pie chart.  The values
    //will add up to 100%.
   private static PieDataset createDataset( ) 
   {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Oncology(30%)" , new Double( 30 ) );  
      dataset.setValue( "Cardiology(40%)" , new Double( 40 ) );   
      dataset.setValue( "Neurology(20%)" , new Double( 20 ) );    
      dataset.setValue( "Surgery(10%)" , new Double( 10 ) );  
      return dataset;         
   }
   
   
   /*Method to generate the actual pie chart.  It uses a dataset as an
   arguement.*/
   private static JFreeChart createChart( PieDataset dataset)
   {
       /*Create the specific chart object.  The ChartFactory class
       contains the method to actually create the pie chart and store it
       in a chart object.*/
       JFreeChart chart = ChartFactory.createPieChart(      
         "Physician specialties",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   
   /*Main function to generate annd display the pie chart using a new PieChart
   object.*/
   public static void main( String[ ] args )
   {
      //Create the pie chart object of physician specialties.
      PieChart specialties = new PieChart ( "Physician specialties" );  
      
      /*Set the size of the pie chart.  Can do this since it is a subclass
      of the ApplicationFrame object. */
      specialties.setSize( 400 , 400 );    
      
      //Method call to ensure the pie chart is centered on the screen.
      RefineryUtilities.centerFrameOnScreen( specialties );    
      
      //Make sure the pie chart is visible for display.
      specialties.setVisible( true ); 
   }
}