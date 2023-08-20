import './App.css';
import PriceSearch from './components/priceSearch/PriceSearch';
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';
import 'react-tabs/style/react-tabs.css';
import Chart from './components/pricecharts/Chart';

function App() {
  return (
    <div>
      <Tabs>
        <TabList>
          <Tab>Price search</Tab>
          <Tab>Prices</Tab>
        </TabList>
        <TabPanel>
          <PriceSearch />
        </TabPanel>
        <TabPanel>
          <Chart />
        </TabPanel>
      </Tabs>


    </div>
  );
}

export default App;
