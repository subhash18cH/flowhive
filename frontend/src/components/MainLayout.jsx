import React from 'react';
import { Outlet } from 'react-router-dom';

const MainLayout = () => {
  return (
    <div className="h-screen bg-gray-50">
      <main className="w-full h-full overflow-auto">
        <Outlet />
      </main>
    </div>
  );
};

export default MainLayout;