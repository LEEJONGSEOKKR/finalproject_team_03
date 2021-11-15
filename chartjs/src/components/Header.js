import React from 'react'

const Header = () => {
    return (
        <header className="header">
        <h1>팬데믹 이후 국내 증시 현황</h1>
        <select>
          <option>국내</option>
          <option>국외</option>
        </select>
      </header>
    )
}

export default Header
