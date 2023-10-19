import React, { useState,useEffect  } from 'react';
import styled from 'styled-components';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { useLocation } from 'react-router-dom';

function Navbar({ className }) {
  const [developmentHovered, setDevelopmentHovered] = useState(false);
  const [graphicHovered, setGraphicHovered] = useState(false);
  const [musicHovered, setMusicHovered] = useState(false);
  const [nameAccount, setNameAccount] = useState('');
  const handleDevelopmentMouseEnter = () => {
    setDevelopmentHovered(true);
  };

  const handleDevelopmentMouseLeave = () => {
    setDevelopmentHovered(false);
  };
  const handleGraphicMouseEnter = () => {
    setGraphicHovered(true);
  };

  const handleGraphicMouseLeave = () => {
    setGraphicHovered(false);
  };
  const handleMusicMouseEnter = () => {
    setMusicHovered(true);
  };

  const handleMusicMouseLeave = () => {
    setMusicHovered(false);
  };

  const location = useLocation();
  const { email } = location.state ;

  useEffect(() => {
    // Fetch the list of accounts
    axios.get('http://localhost:8085/api/v1/accounts/list')
      .then((response) => {
        // Assuming the response data is an array of accounts
        const accounts = response.data;
        
        // Find the account with accountid 5
        const accountWithId5 = accounts.find((account) => account.email ===  email );

        if (accountWithId5) {
          // If the account exists, set its nameaccount to the state
          setNameAccount(accountWithId5.accountname);
        } else {
          // Handle the case where the account with accountid 5 is not found
          setNameAccount('Guest'); // or any other default value
        }
      })
      .catch((error) => {
        console.error('Error fetching accounts:', error);
      });
  }, [email]);


  return (
    <header className={className}>
      <Link to="/home" className="text">Logo</Link>
      <div
        onMouseEnter={handleDevelopmentMouseEnter}
        onMouseLeave={handleDevelopmentMouseLeave}
        className={`text ${developmentHovered ? 'hovered' : ''}`}
      > <Link to="/develop">Development</Link>
        {developmentHovered && (
          <div className="submenu">
            <Link to="/web">Web</Link>
            <Link to="/mobile">Mobile</Link>
            <Link to="/desktop">Desktop</Link>
          </div>
        )}
      </div>

      <div
        onMouseEnter={handleGraphicMouseEnter}
        onMouseLeave={handleGraphicMouseLeave}
        className={`text ${graphicHovered ? 'hovered' : ''}`}
      > <Link to="/graphic" >Graphic</Link>
        {graphicHovered && (
          <div className="submenu">
            <Link to="/logo">Logo Design</Link>
            <Link to="/sticker">Sticker Design</Link>
            <Link to="/character">Character Design</Link>
            <Link to="/draw-cartoon">Draw cartoons</Link>
            <Link to="/3d-models">3D Models</Link>
            <Link to="/banner">Banner advertising design</Link>

          </div>
        )}
      </div>

      <div
        onMouseEnter={handleMusicMouseEnter}
        onMouseLeave={handleMusicMouseLeave}
        className={`text ${musicHovered ? 'hovered' : ''}`}
      > <Link to="/music" >Music</Link>
        {musicHovered && (
          <div className="submenu">
            <Link to="/beat">Beat</Link>


          </div>
        )}
      </div>

      <Link className="picture">pic</Link>
      <Link className="picture1">pic</Link>
      <Link to="/register" className="text1">Sign-up</Link>
      
      <Link to="/" className="text">{nameAccount || 'Guest'}</Link>
    </header>

  );
}

Navbar.propTypes = {
  className: PropTypes.string.isRequired,
};

export default styled(Navbar)`
  height: 48px;
  width: 100%;
  background-color: #ffffff;
  border-bottom: 1px solid #dee2e6;
  box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.075);
  top: 0;
  /* padding: 2rem; */
  position: fixed;
  z-index: 100;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-weight: bold;

  .text {
    color: black;
    text-decoration: none;
    padding: 10px;
    transition: background-color 0.3s, color 0.3s;
  }
 
  .music {
    margin-right: 300px;
    text-decoration: none;
    padding: 10px;
    transition: background-color 0.3s, color 0.3s;
  }
  .picture {
    margin-right: -100px;
    text-decoration: none;
    padding: 10px;
    transition: background-color 0.3s, color 0.3s;
  }
  .picture1 {
    margin-right: -50px;
    text-decoration: none;
    padding: 10px;
    transition: background-color 0.3s, color 0.3s;
  }
  .text:hover,
  .music:hover,
  .picture:hover,
  .picture1:hover {
    background-color: black;
    color: white;
  }
  
  .text.hovered {
    position: relative;
  }
  
  .submenu {
    display: none;
    position: absolute;
    top: 100%;
    left: 0;
    background-color: white;
    border: 1px solid #dee2e6;
  }
  
  .text.hovered .submenu {
    width: 180px;
    display: block;
  }

  .submenu a {
    display: block;
    padding: 5px 10px;
    color: black;
    text-decoration: none;
  }
  
  .submenu a:hover {
    background-color: #f8f9fa;
  }
`;
