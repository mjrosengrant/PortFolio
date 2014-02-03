/* This was my first program written in the Service Oriented Architecture. It was the first time I really utilized online services and APIs, and built something that actually useful. It utilized the internet and would and inform me of something I would not have known otherwise.Services give you access to incredible amounts of information. Imagine if Christopher Coloumbus was able to use reverse geocoding. It would have made his job a hell of a lot easier. 

I missed the SuperBowl to finish this project. It's the first time in 21 years I have not watched it. It was kind of sad, but that's the sacrifice you make.*/

namespace MikeRosengrantsBrowser
{
    public partial class Browser : Form
    {
        public Browser()
        {
            InitializeComponent();
        }

        private void btnGo_Click(object sender, EventArgs e)
        {
            webBrowser1.Navigate(txtUrl.Text);
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            StockQuotes.ServiceClient stocks = new StockQuotes.ServiceClient();
            string stockquote = stocks.getStockquote(textBox1.Text);
            textBox2.Text = stocks.getStockquote(textBox1.Text);

	}

        private void button2_Click(object sender, EventArgs e)
        {
            String zipCode = textBox3.Text;
            com.cdyne.wsf.WeatherSoapClient client = new com.cdyne.wsf.WeatherSoapClient("WeatherSoap");

            com.cdyne.wsf.ForecastReturn location = client.GetCityForecastByZIP(zipCode);
            if (location.Success)
            {
                // Prints the city and State of the Local Zip Code
                label2.Text = location.City + ", " + location.State;

                //Prints Daytime High and Morning Low
                label14.Text = location.ForecastResult[0].Temperatures.DaytimeHigh;
                label13.Text = location.ForecastResult[0].Temperatures.MorningLow;
                label15.Text = location.ForecastResult[1].Temperatures.MorningLow;
                label16.Text = location.ForecastResult[1].Temperatures.DaytimeHigh;
                label17.Text = location.ForecastResult[2].Temperatures.MorningLow;
                label18.Text = location.ForecastResult[2].Temperatures.DaytimeHigh;
                label19.Text = location.ForecastResult[3].Temperatures.MorningLow;
                label20.Text = location.ForecastResult[3].Temperatures.DaytimeHigh;
                label21.Text = location.ForecastResult[4].Temperatures.MorningLow;
                label22.Text = location.ForecastResult[4].Temperatures.DaytimeHigh;


                //Prints Latitude and Longitude 
                LatitudeLookup.AddressLookupSoapClient client2 = new LatitudeLookup.AddressLookupSoapClient("AddressLookupSoap12");
                LatitudeLookup.Address address = client2.CheckAddressW2lines(" ", " ", zipCode, location.City, location.State, "0");
                label24.Text = address.AvgLatitude + ", " + address.AvgLongitude; 


            }
        }
    }
}
