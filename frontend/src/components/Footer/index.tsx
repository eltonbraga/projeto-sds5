import React from 'react';

const NavBar = () => {
    return (
        <footer className="footer mt-auto py-3 bg-dark">
            <div className="container">
                <p className="text-light">App desenvolvido por <a href="https://github.com/eltonbraga" target="_blank" rel="noreferrer">Elton Braga</a></p>
                <p className="text-light"><small><strong>Semana Spring React</strong><br />
                    Projeto desenvolvido: <a href="https://instagram.com/eltonbragasilva" target="_blank" rel="noreferrer">@eltonbragasilva</a></small></p>
            </div>
        </footer>
    );
}

export default NavBar;