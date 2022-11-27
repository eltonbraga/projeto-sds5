import NavBar from './components/NavBar';
import Footer from './components/Footer';
import React from 'react';
import DataTable from './components/DataTable';

function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className='text-primary'> Projeto dev vendas</h1>
        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
