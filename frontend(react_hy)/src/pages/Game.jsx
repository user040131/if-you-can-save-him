import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import './Game.css';

const Game = () => {
  const location = useLocation();
  const navigate = useNavigate();

  const level = location.state?.level || 'easy';
  const [answer, setAnswer] = useState(
    (location.state?.answer || '').toUpperCase()
  );  
  const [topic, setTopic] = useState(location.state?.topic || '');

  // ✅ wordLength 제거 (불필요하므로 삭제)
  const [guessed, setGuessed] = useState([]);
  const [mistakeCount, setMistakeCount] = useState(0);

  const rows = [
    'QWERTYUIOP'.split(''),
    'ASDFGHJKL'.split(''),
    'ZXCVBNM'.split(''),
  ];

  const isCorrect = answer.split('').every(char => guessed.includes(char));

  useEffect(() => {
    if (isCorrect) {
      navigate('/result', { state: { result: 'success' } });
    } else if (mistakeCount >= 6) {
      navigate('/result', { state: { result: 'fail' } });
    }
  }, [guessed, mistakeCount, navigate, isCorrect]);

  const handleClick = (letter) => {
    if (guessed.includes(letter)) return;

    setGuessed([...guessed, letter]);

    if (!answer.includes(letter)) {
      setMistakeCount((prev) => prev + 1);
    }
  };

  const renderUnderlines = () => {
    return answer.split('').map((char, idx) => (
      <span className="letter-box" key={idx}>
        {guessed.includes(char) ? char : ''}
      </span>
    ));
  };

  return (
    <div className="game-screen">
      <div className="game-level">{level.toUpperCase()}</div>

      {/* 토픽 */}
      <div className="topic">Topic : <span>{topic}</span></div>

      {/* 행맨 이미지 */}
      <img
        src={`/hangman${mistakeCount}.png`}
        alt={`hangman-${mistakeCount}`}
        className="hangman-image"
      />

      {/* 밑줄 및 정답 표시 */}
      <div className="answer-area">{renderUnderlines()}</div>

      {/* 알파벳 버튼 */}
      <div className="letter-buttons">
        {rows.map((row, rowIndex) => (
          <div className="button-row" key={rowIndex}>
            {row.map((letter) => (
              <button
                key={letter}
                className={`letter-button ${
                  guessed.includes(letter)
                    ? answer.includes(letter)
                      ? 'correct'
                      : 'wrong'
                    : ''
                }`}
                onClick={() => handleClick(letter)}
                disabled={guessed.includes(letter)}
              >
                {letter}
              </button>
            ))}
          </div>
        ))}
      </div>
    </div>
  );
};

export default Game;





