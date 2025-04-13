import React from 'react';
import { useNavigate } from 'react-router-dom';
import './LevelSelect.css'; 
import axios from 'axios';

const LevelSelect = () => {
  const navigate = useNavigate();

  const handleSelect = async (levelStr) => {
    const levelMap = {
      Easy: 0,
      Medium: 1,
      Hard: 2,
    };
    const difficulty = levelMap[levelStr];

    try {
      // 백엔드에 POST 요청 보내기
      const res = await axios.post('http://localhost:8080/game/start', { difficulty}); // JSON POST
      const { answer, topic } = res.data;

      // Game 페이지로 이동 + 모든 데이터 전달
      navigate('/game', {
        state: {
          level: levelStr.toLowerCase(), // 'easy', 'medium', 'hard'
          answer,
          topic,
        },
      });
    } catch (err) {
      console.error('게임 시작 API 요청 실패:', err);
      alert('서버와 통신에 실패했습니다.');
    }
  };

  return (
    <div className="level-select">
      <h1> Select Level </h1>
      <button className="level-button" onClick={() => handleSelect('Easy')}>Easy</button>
      <button className="level-button" onClick={() => handleSelect('Medium')}>Medium</button>
      <button className="level-button" onClick={() => handleSelect('Hard')}>Hard</button>
    </div>
  );
};

export default LevelSelect;

