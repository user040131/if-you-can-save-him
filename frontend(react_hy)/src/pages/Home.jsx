import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import './Home.css';

const Home = () => {
    const navigate = useNavigate();

    useEffect(() => {
      const handleKeyDown = () => {
        navigate('/level');
      };
  
      window.addEventListener('keydown', handleKeyDown);
  
      return () => {
        window.removeEventListener('keydown', handleKeyDown);
      };
    }, [navigate]);

    return (
        <div className="start-screen">
          <p className="Stackers">from Stackers</p>
          <h1 id="gamename">If (you can) save him;</h1>
          <p id="gamestart">Press any key to start</p>
        </div>
    );
};

export default Home;
