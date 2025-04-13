import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import './Result.css';

const Result = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const result = location.state?.result === 'success' ? 'saved' : 'lost';

  return (
    <div className="result-page">
      <p className="top-text">at last...</p>
      <p className="Stackers">from Stackers</p>
      <div className="result-print">You <span>{result}</span> him!</div>
      <button className="restart-button" onClick={() => navigate('/')}>
        Restart
      </button>
    </div>
  );
};

export default Result;

