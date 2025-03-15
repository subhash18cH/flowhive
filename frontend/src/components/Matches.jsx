import React from 'react'
import MySideBar from './MySideBar'

const Matches = () => {
  return (
    <>
      <div>
        <MySideBar />
      </div>

      <div className='w-full'>
        <div className='flex gap-36 items-center mt-32 ml-28'>
          <div>
            <h1 className='text-3xl font-bold'>Sent Requests</h1>
          </div>
          <div>
            <h1 className='text-3xl font-bold'>Incoming Requests</h1>
          </div>

        </div>
      </div>
    </>
  )
}

export default Matches